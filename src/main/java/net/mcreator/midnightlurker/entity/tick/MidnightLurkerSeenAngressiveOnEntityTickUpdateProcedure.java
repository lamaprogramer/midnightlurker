package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
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
import net.minecraft.world.WorldAccess;

public class MidnightLurkerSeenAngressiveOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
			MidnightlurkerMod.queueServerWork(10, () -> {
				IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
				if (dataSaver.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					dataSaver.getPersistentData().putDouble("SoundActivate", (dataSaver.getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (dataSaver.getPersistentData().getDouble("SoundActivate") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
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

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerSeenAngressiveEntity) {
				if (world instanceof ServerWorld level) {
					Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
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

				SoundUtil.playsound(world, x, y ,z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
			}
		}
	}
}
