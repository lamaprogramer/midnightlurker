package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class JumpscareFrame1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareTimer") == 46
                && ((IEntityDataSaver) entity).getPersistentData().getDouble("JumpscareActive") == 1;
    }
}
