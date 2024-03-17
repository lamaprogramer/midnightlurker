package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.WorldAccess;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class ChasetimerfortestingDisplayOverlayIngameProcedure {
	public static boolean execute(WorldAccess world) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay) {
			return true;
		} else if (!MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay) {
			return false;
		}
		return false;
	}
}
