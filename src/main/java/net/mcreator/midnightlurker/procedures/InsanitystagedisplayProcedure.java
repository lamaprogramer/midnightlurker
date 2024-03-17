package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class InsanitystagedisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("#").format(((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage"));
	}
}
