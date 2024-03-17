package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

import java.io.File;

public class ShowJump2Stage0Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("JumpscareActive") == 1
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 0
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareRandom") == 1) {
			return true;
		}
		return false;
	}
}
