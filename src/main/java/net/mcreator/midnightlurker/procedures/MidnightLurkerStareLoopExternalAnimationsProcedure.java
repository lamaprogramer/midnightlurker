package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class MidnightLurkerStareLoopExternalAnimationsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("StareCountdown") <= 400 && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() : 0) > 2) {
			return true;
		}
		return false;
	}
}
