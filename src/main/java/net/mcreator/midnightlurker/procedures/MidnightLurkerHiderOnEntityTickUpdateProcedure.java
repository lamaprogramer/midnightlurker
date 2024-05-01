package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerHiderOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.DESERT) || world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.BEACH)) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehidersand");
		} else if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.SNOWY_SLOPES) || world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.SNOWY_BEACH)
				|| world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.SNOWY_PLAINS) || world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.SNOWY_TAIGA)
				|| world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.FROZEN_PEAKS) || world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.ICE_SPIKES)) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehidersnow");
		} else if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.BADLANDS)) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehiderredsand");
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 255, false, false));
		}
		if (!entity.isSneaking()) {
			if (Math.random() > 0.9) {
				if (world instanceof ServerWorld _level)
					_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Hiding") == 1) {
			entity.setSneaking(true);
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Hiding") == 0) {
			entity.setSneaking(false);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(200, () -> {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
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
					MidnightlurkerMod.queueServerWork(7, () -> {
						if (!((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER)
								|| !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER)) {
							if (world instanceof ServerWorld _level) {
								Entity entityToSpawn = MidnightlurkerModEntities.VOID_GATEWAY.spawn(_level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYaw(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerHiderEntity) {
					((MidnightLurkerHiderEntity) entity).setAnimation("teleport8");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}

		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
			if ((entity.getHorizontalFacing()) == Direction.SOUTH && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getHorizontalFacing()) == Direction.NORTH
					|| (entity.getHorizontalFacing()) == Direction.NORTH && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.SOUTH
					|| (entity.getHorizontalFacing()) == Direction.EAST && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.WEST
					|| (entity.getHorizontalFacing()) == Direction.WEST && (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.EAST
					|| EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70), entity, 70) instanceof MidnightLurkerHiderEntity || !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("Hiding", 1);
			} else {
				((IEntityDataSaver)entity).getPersistentData().putDouble("Hiding", 0);
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
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("encount", (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") + 1));
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") == 1) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					}
				}
			}
		}
	}
}
