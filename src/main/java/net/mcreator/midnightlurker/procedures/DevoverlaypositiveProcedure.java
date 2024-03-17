package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.WorldAccess;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class DevoverlaypositiveProcedure {
	public static void execute(WorldAccess world) {
		if (!MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay) {
			MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay = true;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
