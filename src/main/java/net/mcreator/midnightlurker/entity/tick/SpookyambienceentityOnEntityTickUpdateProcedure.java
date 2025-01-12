package net.mcreator.midnightlurker.entity.tick;

import net.minecraft.entity.Entity;
import net.minecraft.world.WorldAccess;

public class SpookyambienceentityOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;

		if (!entity.getWorld().isClient()) entity.discard();
	}
}
