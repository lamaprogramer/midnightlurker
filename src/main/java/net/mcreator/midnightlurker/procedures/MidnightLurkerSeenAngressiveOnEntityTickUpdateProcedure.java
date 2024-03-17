package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerSeenAngressiveOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(10, () -> {
				IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
				if (dataSaver.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					dataSaver.getPersistentData().putDouble("SoundActivate", (dataSaver.getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (dataSaver.getPersistentData().getDouble("SoundActivate") == 1) {
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
				if (entity instanceof MidnightLurkerSeenAngressiveEntity) {
					((MidnightLurkerSeenAngressiveEntity) entity).setAnimation("teleport");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerSeenAngressiveEntity) {
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(_level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYaw(entity.getYaw());
						entityToSpawn.setBodyYaw(entity.getYaw());
						entityToSpawn.setHeadYaw(entity.getYaw());
						entityToSpawn.setPitch(entity.getPitch());
						entityToSpawn.setVelocity(0, 0, 0);
					}
				}
				if (!entity.getWorld().isClient())
					entity.discard();
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
