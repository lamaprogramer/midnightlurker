package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerStareOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(StatusEffects.SLOWNESS) && ((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") == 401) {
            _livEnt0.removeStatusEffect(StatusEffects.SLOWNESS);
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(100, () -> {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("SoundActivate", (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof World _level) {
							if (!_level.isClient()) {
								_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
							} else {
								_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerStareEntity) {
					((MidnightLurkerStareEntity) entity).setAnimation("teleport9");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") >= 401) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("Staringat", 0);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Staringat") == 1) {
			entity.setSneaking(true);
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Staringat") == 0) {
			entity.setSneaking(false);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
			if ((entity.getHorizontalFacing()) == Direction.SOUTH && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getHorizontalFacing()) == Direction.NORTH
					|| (entity.getHorizontalFacing()) == Direction.NORTH && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.SOUTH
					|| (entity.getHorizontalFacing()) == Direction.EAST && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.WEST
					|| (entity.getHorizontalFacing()) == Direction.WEST && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.EAST || EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70), entity, 70) instanceof MidnightLurkerStareEntity) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") < 401) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("StareCountdown", (((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") <= 400) {
					if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
						_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 255, false, false));
					((IEntityDataSaver)entity).getPersistentData().putDouble("Staringat", 1);
				} else if (entity instanceof LivingEntity _livEnt61 && _livEnt61.hasStatusEffect(StatusEffects.SLOWNESS) && ((IEntityDataSaver)entity).getPersistentData().getDouble("StareCountdown") == 401) {
                    _livEnt61.removeStatusEffect(StatusEffects.SLOWNESS);
				}
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("Staringat", 0);
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
			entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, new Vec3d((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getX()), (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getY()), (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getZ())));
		}
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.EAST) {
			entity.setVelocity(new Vec3d(0.2, 0.2, (entity.getVelocity().getZ())));
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.WEST) {
			entity.setVelocity(new Vec3d((-0.2), 0.2, (entity.getVelocity().getZ())));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().getX()), 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.NORTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().getX()), 0.2, (-0.2)));
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") < 300) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundLurk", (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld _level)
						_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.7");
				}
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("encount", (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") + 1));
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") == 1) {
			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					}
				}
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).hasVehicle()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 255, false, false));
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 0, false, false));
			} else if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.DIAMOND_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 1, false, false));
			} else if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.NETHERITE_CHESTPLATE
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.NETHERITE_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 2, false, false));
			}
			if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 0, false, false));
			} else if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.DIAMOND_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 2, false, false));
			} else if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.NETHERITE_CHESTPLATE
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS
					&& (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 15, 15, 15) instanceof LivingEntity _entGetArmor ? _entGetArmor.getEquippedStack(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.NETHERITE_BOOTS) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3, 3, false, false));
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getBoolean("Stunned")) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") <= 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", 1);
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") > 0 && ((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") < 200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") >= 200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", 0);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") >= 98) {
			if (((IEntityDataSaver)entity).getPersistentData().getBoolean("Stunned")) {
				((IEntityDataSaver)entity).getPersistentData().putBoolean("Stunned", false);
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") > 0 && ((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") < 98) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3, 255, false, false));
			if (entity instanceof MidnightLurkerStareEntity) {
				((MidnightLurkerStareEntity) entity).setAnimation("stunned9");
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") == 2) {
			if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stunned neutral @a ~ ~ ~ 1 1");
			}
			MidnightlurkerMod.queueServerWork(30, () -> {
				if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
					if (world instanceof ServerWorld _level)
						_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
								"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.7 1");
				}
			});
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") == 88) {
			if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
			}
		}
	}
}
