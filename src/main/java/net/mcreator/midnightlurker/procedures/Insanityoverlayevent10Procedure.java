package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class Insanityoverlayevent10Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof PlayerEntity) {
                return ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityOverlayTime") == 10;
			}
		}
		return false;
	}
}
