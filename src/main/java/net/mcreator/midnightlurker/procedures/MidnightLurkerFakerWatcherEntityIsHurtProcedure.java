package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerFakerWatcherEntityIsHurtProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerFakerWatcherEntity);
    }
}
