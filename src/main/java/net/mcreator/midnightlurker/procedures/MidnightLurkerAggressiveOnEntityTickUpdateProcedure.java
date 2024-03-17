package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MidnightLurkerAggressiveOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if ((world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			{
				BlockPos _pos = BlockPos.ofFloored(x + 1, y, z);
				Block.dropStacks(world.getBlockState(_pos), world, BlockPos.ofFloored(x + 1, y + 0.5, z), null);
				world.breakBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			{
				BlockPos _pos = BlockPos.ofFloored(x - 1, y, z);
				Block.dropStacks(world.getBlockState(_pos), world, BlockPos.ofFloored(x + 1, y + 0.5, z), null);
				world.breakBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			{
				BlockPos _pos = BlockPos.ofFloored(x, y, z + 1);
				Block.dropStacks(world.getBlockState(_pos), world, BlockPos.ofFloored(x, y + 0.5, z + 1), null);
				world.breakBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			{
				BlockPos _pos = BlockPos.ofFloored(x, y, z - 1);
				Block.dropStacks(world.getBlockState(_pos), world, BlockPos.ofFloored(x, y + 0.5, z - 1), null);
				world.breakBlock(_pos, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
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
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 4, y, z)).isOpaque() && entity.getY() < 50) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", 100);
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.breakBlock(BlockPos.ofFloored(x + 1, y + 0, z), false);
				world.breakBlock(BlockPos.ofFloored(x + 1, y + 1, z), false);
				world.breakBlock(BlockPos.ofFloored(x + 1, y + 2, z), false);
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5 + 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_2.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5 + 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_3.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5 + 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_4.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5 + 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 4, y, z)).isOpaque() && entity.getY() < 50) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", 100);
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.breakBlock(BlockPos.ofFloored(x - 1, y + 0, z), false);
				world.breakBlock(BlockPos.ofFloored(x - 1, y + 1, z), false);
				world.breakBlock(BlockPos.ofFloored(x - 1, y + 2, z), false);
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX.spawn(_level, BlockPos.ofFloored((Math.floor(x) + 0.5) - 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_2.spawn(_level, BlockPos.ofFloored((Math.floor(x) + 0.5) - 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_3.spawn(_level, BlockPos.ofFloored((Math.floor(x) + 0.5) - 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_4.spawn(_level, BlockPos.ofFloored((Math.floor(x) + 0.5) - 1, Math.floor(y), Math.floor(z) + 0.5), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y, z + 4)).isOpaque() && entity.getY() < 50) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", 100);
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.breakBlock(BlockPos.ofFloored(x, y + 0, z + 1), false);
				world.breakBlock(BlockPos.ofFloored(x, y + 1, z + 1), false);
				world.breakBlock(BlockPos.ofFloored(x, y + 2, z + 1), false);
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), Math.floor(z) + 0.5 + 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_2.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), Math.floor(z) + 0.5 + 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_3.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), Math.floor(z) + 0.5 + 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_4.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), Math.floor(z) + 0.5 + 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y, z - 4)).isOpaque() && entity.getY() < 50) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", 100);
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.breakBlock(BlockPos.ofFloored(x, y + 0, z - 1), false);
				world.breakBlock(BlockPos.ofFloored(x, y + 1, z - 1), false);
				world.breakBlock(BlockPos.ofFloored(x, y + 2, z - 1), false);
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerfinalbreak")), SoundCategory.BLOCKS, 1, 1, false);
					}
				}
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), (Math.floor(z) + 0.5) - 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_2.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), (Math.floor(z) + 0.5) - 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_3.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), (Math.floor(z) + 0.5) - 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(
							new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.DESTROYTEX_4.spawn(_level, BlockPos.ofFloored(Math.floor(x) + 0.5, Math.floor(y), (Math.floor(z) + 0.5) - 1), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
			}
		}
		if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3, 0, false, false));
		}
		if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3, 0, false, false));
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles((DefaultParticleType) (MidnightlurkerModParticleTypes.VOID_DOT), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if ((world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x + 1, y, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x - 1, y, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y, z + 1), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x + 1, y + 1, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x - 1, y + 1, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y + 1, z + 1), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y + 1, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x + 1, y + 2, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x - 1, y + 2, z), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y + 2, z + 1), false);
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1))).getBlock() == Blocks.GLASS) {
			world.breakBlock(BlockPos.ofFloored(x, y + 2, z - 1), false);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerScream") == 0) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerScream", 110);
		} else {
			((IEntityDataSaver)entity).getPersistentData().putDouble("LurkerScream", (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerScream") - 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("LurkerScream") == 1) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
				MidnightlurkerMod.queueServerWork(1, () -> {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerscream")), SoundCategory.NEUTRAL, 50, 1);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerscream")), SoundCategory.NEUTRAL, 50, 1, false);
						}
					}
				});
			}
		}
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (!mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 0) {
							((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", 1201);
						} else {
							((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") - 1));
						}
					}
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && ((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1) {
						if (entity instanceof MidnightLurkerAggressiveEntity) {
							((MidnightLurkerAggressiveEntity) entity).setAnimation("teleport1");
						}
						if (entity instanceof MidnightlurkerNEEntity) {
							((MidnightlurkerNEEntity) entity).setAnimation("teleport1");
						}
						MidnightlurkerMod.queueServerWork(2, () -> {
							if (world instanceof World _level) {
								if (!_level.isClient()) {
									_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
								} else {
									_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
								}
							}
						});
						MidnightlurkerMod.queueServerWork(13, () -> {
							if (!entity.getWorld().isClient())
								entity.discard();
						});
					}
					
					IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100);
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()
							&& dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& ((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1) {

						double _setval = 0;
						
						dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));
						
						dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));
						
						dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));
						
						MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
					}
				} else if (mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 0) {
							((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", 2401);
						} else {
							((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") - 1));
						}
					}
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && ((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1) {
						if (entity instanceof MidnightLurkerAggressiveEntity) {
							((MidnightLurkerAggressiveEntity) entity).setAnimation("teleport1");
						}
						if (entity instanceof MidnightlurkerNEEntity) {
							((MidnightlurkerNEEntity) entity).setAnimation("teleport1");
						}
						MidnightlurkerMod.queueServerWork(2, () -> {
							if (world instanceof World _level) {
								if (!_level.isClient()) {
									_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
								} else {
									_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
								}
							}
						});
						MidnightlurkerMod.queueServerWork(13, () -> {
							if (!entity.getWorld().isClient())
								entity.discard();
						});
					}

					IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100);
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()
							&& dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& ((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1) {
						
						double _setval = 0;

						dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));

						dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));

						dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100));
						
						MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
					}
				}
				if (mainjsonobject.get("lurker_chase_music").getAsBoolean() && !mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1199) {
						if (world instanceof ServerWorld _level)
							_level.getServer().getCommandManager().executeWithPrefix(
									new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
									"/playsound midnightlurker:lurkerchase neutral @a");
					}
				} else if (!mainjsonobject.get("lurker_chase_music").getAsBoolean() && !mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 1199) {
						if (world instanceof World _level) {
							if (!_level.isClient()) {
								_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0);
							} else {
								_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0, false);
							}
						}
					}
				} else if (mainjsonobject.get("lurker_chase_music").getAsBoolean() && mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 2399) {
						if (world instanceof ServerWorld _level)
							_level.getServer().getCommandManager().executeWithPrefix(
									new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
									"/playsound midnightlurker:lurkerchase2 neutral @a");
					}
				} else if (!mainjsonobject.get("lurker_chase_music").getAsBoolean() && mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") == 2399) {
						if (world instanceof World _level) {
							if (!_level.isClient()) {
								_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase2")), SoundCategory.NEUTRAL, 0, 0);
							} else {
								_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase2")), SoundCategory.NEUTRAL, 0, 0, false);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
			if ((world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") < 1201) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", 1201);
				}
			}
		} else if (mainjsonobject.get("longer_lurker_chase").getAsBoolean()) {
			if ((world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("AngeryTime") < 2401) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("AngeryTime", 2401);
				}
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).hasVehicle()) {
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
	}
}
