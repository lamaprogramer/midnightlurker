package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerNEOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		MidnightlurkerMod.queueServerWork(6, () -> {
			if (!((entity.level.dimension()) == Level.NETHER) && !((entity.level.dimension()) == Level.END)) {
				if (!entity.level.isClientSide())
					entity.discard();
			}
		});
	}
}
