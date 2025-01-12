package net.mcreator.midnightlurker.procedures;

import com.google.gson.JsonObject;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.ConfigUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class InsanityStageTimerProcedure {
    public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		JsonObject config = ConfigUtil.loadConfig();
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		double insanityCountdownTime = config.get("insanity_countdown_time").getAsDouble();

		if (insanityCountdownTime == 1) {
			handleInsanityCounter(entity, dataSaver, world, 6000);
		} else if (insanityCountdownTime == 2) {
			handleInsanityCounter(entity, dataSaver, world, 12000);
		} else if (insanityCountdownTime == 3) {
			handleInsanityCounter(entity, dataSaver, world, 24000);
		} else if (insanityCountdownTime == 4) {
			handleInsanityCounter(entity, dataSaver, world, 36000);
		}
	}

	private static void handleInsanityCounter(Entity entity, IEntityDataSaver dataSaver, WorldAccess world, int timerMax) {
		if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7 && MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
			if (dataSaver.getPersistentData().getDouble("InsanityTimer") < timerMax+1) {
				double _setval = dataSaver.getPersistentData().getDouble("InsanityTimer") + 1;
				dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
			}
			if (dataSaver.getPersistentData().getDouble("InsanityTimer") == timerMax && dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
				if (Math.random() > 0.3) {
					double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
					dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
				}
			}
		}
		if (dataSaver.getPersistentData().getDouble("InsanityTimer") >= timerMax+1) {
			dataSaver.getPersistentData().putDouble("InsanityTimer", 0);
		}
		if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7 && (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
			if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7 && dataSaver.getPersistentData().getDouble("InsanityReset") < 90) {
				double _setval = dataSaver.getPersistentData().getDouble("InsanityReset") + 1;
				dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
			}
			if (dataSaver.getPersistentData().getDouble("InsanityReset") == 89) {
				dataSaver.getPersistentData().putDouble("InsanityStage", 0);
				dataSaver.getPersistentData().putDouble("InsanityTimer", 0);
			}
		}
		if (dataSaver.getPersistentData().getDouble("InsanityReset") == 90) {
			dataSaver.getPersistentData().putDouble("InsanityReset", 0);
		}
		if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7 && !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7 && dataSaver.getPersistentData().getDouble("InsanityReset") > 0) {
				dataSaver.getPersistentData().putDouble("InsanityReset", 0);
			}
		}
	}
}
