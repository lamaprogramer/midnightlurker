package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerRunawayOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		EntityTickActions.handleAutoDismount(entity);
		
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 20)) {
			MidnightlurkerMod.queueServerWork(400, () -> {
				if (entityData.getPersistentData().getDouble("SoundActivate2") < 3 && !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
					entityData.getPersistentData().putDouble("SoundActivate2", (entityData.getPersistentData().getDouble("SoundActivate2") + 1));
				}

				if (entityData.getPersistentData().getDouble("SoundActivate2") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
					});
				}

				if (entity instanceof MidnightLurkerRunawayEntity) {
					((MidnightLurkerRunawayEntity) entity).setAnimation("teleport6");
				}

				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);

		if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasStatusEffect(StatusEffects.SLOWNESS)
				&& !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 20)) {
            _livEnt22.removeStatusEffect(StatusEffects.SLOWNESS);
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerRunawayEntity) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeStatusEffect(StatusEffects.SLOWNESS);
			}
		}

		EntityTickActions.handleClimbing(world, entity, x ,y ,z);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
			if (entityData.getPersistentData().getDouble("encount") < 2) {
				entityData.getPersistentData().putDouble("encount", (entityData.getPersistentData().getDouble("encount") + 1));
			}
		}

		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
		if (entityData.getPersistentData().getDouble("encount") == 1) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
					}
				}
			}
		}

		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
	}
}
