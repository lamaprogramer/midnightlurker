package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class MidnightLurkerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == Level.NETHER || (entity.level.dimension()) == Level.END) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
