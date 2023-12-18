package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class MidnightLurkerHiderLoopExternalAnimationsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getDuration() : 0) > 20 && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.LUCK) : false)) {
			return true;
		}
		return false;
	}
}
