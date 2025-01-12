package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class InvisibleAnimalKillerOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 8)) {
			if (!entity.getWorld().isClient()) entity.discard();
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
			if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
				livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3, 255, false, false));
			}
		}
	}
}
