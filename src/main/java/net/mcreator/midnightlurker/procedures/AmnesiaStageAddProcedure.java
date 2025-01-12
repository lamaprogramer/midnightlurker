package net.mcreator.midnightlurker.procedures;

import com.google.gson.JsonObject;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.ConfigUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;


public class AmnesiaStageAddProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		JsonObject config = ConfigUtil.loadConfig();
		if (config.get("amnesia").getAsBoolean()) {
			if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6) {
				if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
					livingEntity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.AMNESIA, 3, 0, false, false));
				}
			}
		}
	}
}
