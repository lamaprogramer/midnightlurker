package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

public class LurkerinwaterconditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return entity.isTouchingWater();
    }
}
