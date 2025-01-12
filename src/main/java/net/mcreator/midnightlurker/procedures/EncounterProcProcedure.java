package net.mcreator.midnightlurker.procedures;

import com.google.gson.JsonObject;
import net.mcreator.midnightlurker.util.ConfigUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;


public class EncounterProcProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		
		JsonObject config = ConfigUtil.loadConfig();
		if (config.get("encounters_progress_stages").getAsBoolean()) {
			IEntityDataSaver entityData = (IEntityDataSaver) entity;
			if (entityData.getPersistentData().getDouble("encounternumber") >= 6) {
				entityData.getPersistentData().putDouble("encounternumber", 0);

				if (entityData.getPersistentData().getDouble("InsanityStage") < 7) {
					double _setval = entityData.getPersistentData().getDouble("InsanityStage") + 1;
					entityData.getPersistentData().putDouble("InsanityStage", _setval);

					entityData.getPersistentData().putDouble("InsanityTimer", 0);
				}
			}
		}
	}
}
