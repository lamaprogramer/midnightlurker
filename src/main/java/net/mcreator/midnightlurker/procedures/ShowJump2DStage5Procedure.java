package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

import java.io.File;

public class ShowJump2DStage5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("JumpscareActive") == 1
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 5) {
			return true;
		}
		return false;
	}
}
