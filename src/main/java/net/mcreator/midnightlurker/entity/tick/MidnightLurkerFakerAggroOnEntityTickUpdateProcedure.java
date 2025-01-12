package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerFakerAggroOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			if (!entity.getWorld().isClient())
				entity.discard();
			
			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
				dataSaver.getPersistentData().putDouble("JumpscareActive", 1);
			}
			if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
				double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
				dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
				dataSaver.getPersistentData().putDouble("InsanityTimer", 0);
			}
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 30)) {
			if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleClimbing(world, entity, x ,y ,z);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 70)) {
			if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).hasVehicle()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 255, false, false));
			}
		}
	}
}
