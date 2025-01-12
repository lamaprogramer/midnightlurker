package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class DeathJumpBackingProcProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;

		IEntityDataSaver entityData = (IEntityDataSaver) entity;
        return entityData.getPersistentData().getDouble("DeathJumpActive") == 1 && entityData.getPersistentData().getDouble("DeathJumpActive") >= 40;
    }
}
