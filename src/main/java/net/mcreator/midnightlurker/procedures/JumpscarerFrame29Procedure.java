package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class JumpscarerFrame29Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("JumpscareTimer") == 11
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1) {
			return true;
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("JumpscareTimer") == 9
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1) {
			return true;
		}
		return false;
	}
}
