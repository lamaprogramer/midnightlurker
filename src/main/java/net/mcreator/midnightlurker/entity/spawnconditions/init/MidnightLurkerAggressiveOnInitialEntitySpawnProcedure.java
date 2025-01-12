package net.mcreator.midnightlurker.entity.spawnconditions.init;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		
		if (entity instanceof MobEntity mobEntity && EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 200, 200, 200) instanceof LivingEntity livingEntity) {
			mobEntity.setTarget(livingEntity);
		}

		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
				livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 1, false, false));
			}
		}
	}
}
