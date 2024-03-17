package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class RedJumpFrame19Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareTimer") == 28
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1;
    }
}
