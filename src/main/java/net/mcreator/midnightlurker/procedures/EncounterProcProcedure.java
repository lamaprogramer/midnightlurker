package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;


public class EncounterProcProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;

		CoreConfig config = MidnightlurkerMod.CONFIG;
		if (config.shouldDoEncountersProgressStages()) {
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
