package net.mcreator.midnightlurker.entity.tick.util;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.AnimatableEntity;
import net.mcreator.midnightlurker.network.MidnightLurkerNetworking;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.world.WorldAccess;

import java.util.Map;

public class EntityTickActions {
    public static void handleAutoDismount(LivingEntity entity) {
        if (entity.hasVehicle()) {
            entity.stopRiding();
        }
    }

    public static void handleClimbing(WorldAccess world, LivingEntity entity, double x, double y, double z) {
        for (Direction direction : new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH}) {
            if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z).offset(direction, 1)).isOpaque()
                    && !world.getBlockState(BlockPos.ofFloored(x, y + 0, z).offset(direction, 1)).isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("midnightlurker:cannotclimb")))
                    && (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
                    && !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y + 52, z), 100.1, 100.1, 100.1), e -> true).isEmpty()
                    && entity.getHorizontalFacing() == direction) {

                Vec3d velocity = direction.getAxis() == Direction.Axis.X ?
                        new Vec3d(0, 0.2, entity.getVelocity().getZ()) :
                        new Vec3d(entity.getVelocity().getX(), 0.2, 0);

                entity.setVelocity(velocity.offset(direction, 0.2));
                break;
            }
        }
    }

    public static void handleParticles(double rand, WorldAccess world, SimpleParticleType particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        if (Math.random() > rand) {
            if (world instanceof ServerWorld level) {
                level.spawnParticles(particle, x, y, z, count, deltaX, deltaY, deltaZ, speed);
            }
        }
    }

    public static void handleGlassBreaking(WorldAccess world, double x, double y, double z) {
        Block[] glassBlocks = new Block[]{Blocks.GLASS, Blocks.GLASS_PANE};

        for (int offsetY = 0; offsetY <= 2; offsetY++) {
            for (Direction direction : new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH}) {
                for (Block glassBlock : glassBlocks) {
                    if ((world.getBlockState(BlockPos.ofFloored(x, y + offsetY, z).offset(direction, 1))).getBlock() == glassBlock) {
                        world.breakBlock(BlockPos.ofFloored(x, y + offsetY, z).offset(direction, 1), false);
                    }
                }
            }
        }
    }

    public static void handleDamageScaling(WorldAccess world, LivingEntity entity, double x, double y, double z) {
        if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15)) {
            if (entity.getWorld().isClient()) {
                if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity playerEntity) {
                    Map<EquipmentSlot, ArmorItem.Type> armorSlots = Map.ofEntries(
                            Map.entry(EquipmentSlot.HEAD, ArmorItem.Type.HELMET),
                            Map.entry(EquipmentSlot.BODY, ArmorItem.Type.BODY),
                            Map.entry(EquipmentSlot.LEGS, ArmorItem.Type.LEGGINGS),
                            Map.entry(EquipmentSlot.FEET, ArmorItem.Type.BOOTS)
                    );

                    int totalDefense = 0;
                    float totalToughness = 0;
                    for (Map.Entry<EquipmentSlot, ArmorItem.Type> entry : armorSlots.entrySet()) {
                        Item item = playerEntity.getEquippedStack(entry.getKey()).getItem();
                        ArmorMaterial armorMaterial = item instanceof ArmorItem ? ((ArmorItem)item).getMaterial().value() : null;
                        if (armorMaterial != null) {
                            totalDefense += armorMaterial.defense().get(entry.getValue());
                            totalToughness += armorMaterial.toughness();
                        }
                    }

                    if (totalDefense >= 20 && totalToughness >= 12.0f) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 3, false, false));
                    } else if (totalDefense >= 20) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 2, false, false));
                    } else if (totalDefense >= 15) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 1, false, false));
                    } else if (totalDefense >= 11) {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 0, false, false));
                    }
                }
            }
        }
    }

    public static void handleBlockBreaking(WorldAccess world, LivingEntity entity, IEntityDataSaver entityData, double x, double y, double z) {
        for (Direction direction : new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH}) {
            if (world.getBlockState(BlockPos.ofFloored(x, y, z).offset(direction, 1)).isOpaque()
                    && !world.getBlockState(BlockPos.ofFloored(x, y, z).offset(direction, 4)).isOpaque()
                    && entity.getY() < 50) {

                if (entityData.getPersistentData().getDouble("LurkerTime") <= 0) {
                    entityData.getPersistentData().putDouble("LurkerTime", 100);
                } else {
                    entityData.getPersistentData().putDouble("LurkerTime", (entityData.getPersistentData().getDouble("LurkerTime") - 1));
                }

                if (entityData.getPersistentData().getDouble("LurkerTime") == 1) {
                    if (entity instanceof AnimatableEntity animatableEntity) {
                        animatableEntity.setAnimation("breaking1");
                    }
                    world.breakBlock(BlockPos.ofFloored(x, y + 0, z).offset(direction, 1), false);
                    world.breakBlock(BlockPos.ofFloored(x, y + 1, z).offset(direction, 1), false);
                    world.breakBlock(BlockPos.ofFloored(x, y + 2, z).offset(direction, 1), false);

                    SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1);

                    if (world instanceof ServerWorld level) {
                        level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerfinalbreak block @a");
                    }
                }

                double lurkerBreakTime = entityData.getPersistentData().getDouble("LurkerTime");
                if (lurkerBreakTime % 10 == 0) {
                    if (entity instanceof AnimatableEntity animatableEntity) {
                        animatableEntity.setAnimation("breaking1");
                    }

                    int breakProgress = (int) (10 - (lurkerBreakTime / 10));
                    if (world instanceof ServerWorld level) {
                        level.setBlockBreakingInfo(entity.getId(), BlockPos.ofFloored(Math.floor(x) , Math.floor(y), Math.floor(z)).offset(direction, 1), breakProgress);
                        level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerfinalbreak block @a");
                    }
                }
                break;
            }
        }
    }

    public static void handleBreakDoors(WorldAccess world, double x, double y, double z) {
        for (Direction direction : new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH}) {
            if ((world.getBlockState(BlockPos.ofFloored(x, y, z).offset(direction, 1))).isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("midnightlurker:lurkerdoors")))) {
                BlockPos doorPos = BlockPos.ofFloored(x, y, z).offset(direction, 1);
                Block.dropStacks(world.getBlockState(doorPos), world, BlockPos.ofFloored(x, y + 0.5, z).offset(direction, 1), null);
                world.breakBlock(doorPos, false);
                break;
            }
        }
    }

    public static void handleLurkerChase(WorldAccess world, LivingEntity entity, IEntityDataSaver entityData, double x, double y, double z) {
        boolean longerLurkerChase = MidnightlurkerMod.CONFIG.shouldDoLongerLurkerChase();
        boolean lurkerChaseMusic = MidnightlurkerMod.CONFIG.shouldDoLurkerChaseMusic();
        int angryTime = longerLurkerChase ? 2400 : 1200;

        if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 100)) {
            if (entityData.getPersistentData().getDouble("AngryTime") == 0) {
                entityData.getPersistentData().putDouble("AngryTime", angryTime + 1);
            } else {
                entityData.getPersistentData().putDouble("AngryTime", (entityData.getPersistentData().getDouble("AngryTime") - 1));
            }

            if (entityData.getPersistentData().getDouble("AngryTime") == 1) {
                if (entity instanceof AnimatableEntity animatableEntity) {
                    animatableEntity.setAnimation("teleport1");
                }

                SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

                MidnightlurkerMod.queueServerWork(13, () -> {
                    if (!entity.getWorld().isClient()) entity.discard();
                });
            }

            ServerPlayerEntity player = (ServerPlayerEntity) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100);
            IEntityDataSaver playerData = (IEntityDataSaver) player;
            if (playerData.getPersistentData().getDouble("InsanityStage") == 7 && entityData.getPersistentData().getDouble("AngryTime") == 1) {
                playerData.getPersistentData().putDouble("InsanityStage", 0);
                playerData.getPersistentData().putDouble("InsanityTimer", 0);
                playerData.getPersistentData().putDouble("InsanityAktive", 0);

                MidnightLurkerNetworking.syncPlayerData(player, "InsanityStage");
                MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
                MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
                MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
                MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
            }
        }

        if (lurkerChaseMusic) {
            if (entityData.getPersistentData().getDouble("AngryTime") == angryTime - 1) {
                if (world instanceof ServerWorld level) {
                    level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerchase neutral @a");
                }
            }
        }

        if (EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 100)) {
            if (entityData.getPersistentData().getDouble("AngryTime") < angryTime+1) {
                entityData.getPersistentData().putDouble("AngryTime", angryTime+1);
            }
        }
    }

    public static void handleLurkerScream(WorldAccess world, LivingEntity entity, IEntityDataSaver entityData) {
        if (entityData.getPersistentData().getDouble("LurkerScream") == 0) {
            entityData.getPersistentData().putDouble("LurkerScream", 110);
        } else {
            entityData.getPersistentData().putDouble("LurkerScream", (entityData.getPersistentData().getDouble("LurkerScream") - 1));
        }

        if (entityData.getPersistentData().getDouble("LurkerScream") == 1) {
            if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 25)) {
                SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerscream")), SoundCategory.NEUTRAL, 50, 1);
            }
        }
    }

    public static void handleEffect(LivingEntity entity, RegistryEntry<StatusEffect> statusEffect, int duration, int amplifier, boolean ambient, boolean visible) {
        if (!entity.getWorld().isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, ambient, visible));
        }
    }

    public static void handleFasterSwimSpeed(WorldAccess world, LivingEntity entity, double x, double y, double z) {
        handleEffect(entity, StatusEffects.DOLPHINS_GRACE, 1, 0, false, false);

        if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 70)) {
            if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).hasVehicle()) {
                if (entity.getWorld().isClient()) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 3, 255, false, false));
                }
            }
        }
    }

    public static void handleSpeedWhenObstructed(WorldAccess world, LivingEntity entity, double x, double y, double z) {
        if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
                && (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
            if (entity.getWorld().isClient())
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3, 0, false, false));
        }

        if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
                && (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
            if (entity.getWorld().isClient())
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3, 0, false, false));
        }
    }

    public static void handleJumpscare(WorldAccess world, LivingEntity entity) {
        if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
            if (!entity.getWorld().isClient()) {
                entity.discard();

                ServerPlayerEntity player = (ServerPlayerEntity) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
                IEntityDataSaver dataSaver = (IEntityDataSaver) player;

                if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
                    dataSaver.getPersistentData().putDouble("JumpscareActive", 1);

                    MidnightLurkerNetworking.syncPlayerData(player, "JumpscareActive");
                }

                if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
                    double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.getPersistentData().putDouble("InsanityTimer", 0);

                    MidnightLurkerNetworking.syncPlayerData(player, "InsanityStage");
                }
            }
        }
    }
}
