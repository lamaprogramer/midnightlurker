package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class JumpscareFrame12Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("JumpscareTimer") == 35
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1) {
			return true;
		}
		return false;
	}
}
