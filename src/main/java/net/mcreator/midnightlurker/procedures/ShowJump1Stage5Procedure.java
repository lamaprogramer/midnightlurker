package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

import java.io.File;

public class ShowJump1Stage5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 5
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareRandom") == 0;
    }
}
