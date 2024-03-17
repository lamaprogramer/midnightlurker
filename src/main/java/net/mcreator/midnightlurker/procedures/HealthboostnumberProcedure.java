package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.WorldAccess;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class HealthboostnumberProcedure {
	public static String execute(WorldAccess world) {
		return new java.text.DecimalFormat("#").format(MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost);
	}
}
