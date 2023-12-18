package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class MidnightLurkerHiderPlayReturnedAnimationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getDuration() : 0) > 20 && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.LUCK) : false)) {
			return "idlehidden8";
		}
		return "empty";
	}
}
