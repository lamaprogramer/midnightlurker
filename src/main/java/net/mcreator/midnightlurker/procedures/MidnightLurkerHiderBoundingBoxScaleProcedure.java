package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class MidnightLurkerHiderBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Hiding") == 1) {
			return 0.1;
		}

		return 1;
	}
}
