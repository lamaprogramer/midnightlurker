package net.mcreator.midnightlurker.procedures;



import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import org.jetbrains.annotations.Nullable;


public class InsanityoverlayrendersProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;

		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof PlayerEntity) {
                LivingEntity _livEnt = (LivingEntity) entity;
                if ((_livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 45 && dataSaver.getPersistentData().getDouble("InsanityOverlayTime") >= 11) {
					dataSaver.getPersistentData().putDouble("InsanityOverlayTime", 0);
				}

                if ((_livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 45 && dataSaver.getPersistentData().getDouble("InsanityOverlayTime") < 10) {
					dataSaver.getPersistentData().putDouble("InsanityOverlayTime", (dataSaver.getPersistentData().getDouble("InsanityOverlayTime") + 1));
				}

                if ((_livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 44 && dataSaver.getPersistentData().getDouble("InsanityOverlayTime") > 0) {
					dataSaver.getPersistentData().putDouble("InsanityOverlayTime", (dataSaver.getPersistentData().getDouble("InsanityOverlayTime") - 1));
                }
			}
		}
		if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY))) {
			if (entity instanceof PlayerEntity) {
				dataSaver.getPersistentData().putDouble("InsanityOverlayTime", 11);
			}
		} else {
            if (_livEnt14.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
                if (entity instanceof PlayerEntity && dataSaver.getPersistentData().getDouble("InsanityOverlayTime") < 0) {
					dataSaver.getPersistentData().putDouble("InsanityOverlayTime", 11);
                }
            }
        }
	}
}
