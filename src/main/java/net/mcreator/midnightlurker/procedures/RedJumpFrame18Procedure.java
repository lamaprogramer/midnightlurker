package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class RedJumpFrame18Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareTimer") == 29
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1;
    }
}
