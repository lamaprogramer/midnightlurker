package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

import java.io.File;

public class ShowJump2DProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 0;
    }
}
