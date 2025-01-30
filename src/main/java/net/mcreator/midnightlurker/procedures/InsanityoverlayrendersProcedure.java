package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;


public class InsanityoverlayrendersProcedure {
	public static void execute(PlayerEntity entity) {
		if (entity == null)
			return;

		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			float step = entity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getFadeFactor(entity, 1);
			dataSaver.getPersistentData().putDouble("InsanityOverlayTime", MathHelper.lerp(step, 0, 10));
		}
	}
}
