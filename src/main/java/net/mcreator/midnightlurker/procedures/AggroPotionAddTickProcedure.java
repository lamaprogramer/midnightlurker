package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class AggroPotionAddTickProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entityData.getPersistentData().getDouble("InsanityStage") == 7) {
			if (EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerAggressiveEntity.class, new Vec3d(x, y, z), 700)) {
				if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
					livingEntity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.LURKER_ANGERED, 2, 0, false, false));
				}
			}
		}
	}
}
