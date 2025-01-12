package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;


public class InsanitySleepProcedure {
    public static void execute(Entity entity) {
		if (entity == null)
			return;
        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (dataSaver.getPersistentData().getDouble("InsanityAktive") > 0) {
            dataSaver.getPersistentData().putDouble("InsanityAktive", 0);
		}
	}
}
