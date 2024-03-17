package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class DeathJumpBackingProcProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("DeathJumpActive") == 1
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("DeathJumpActive") >= 40;
    }
}
