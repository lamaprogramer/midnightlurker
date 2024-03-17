package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.WorldAccess;
import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.io.File;

public class SpookyambienceentityOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!entity.getWorld().isClient())
				entity.discard();
		});
	}
}
