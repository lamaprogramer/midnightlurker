package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class PhantomheadattackplayerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("lookingatphantomhead") > 0 || ((IEntityDataSaver) entity).getPersistentData().getDouble("AttackOnSight") == 50;
    }
}
