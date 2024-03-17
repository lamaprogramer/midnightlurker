package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.minecraft.world.WorldAccess;

public class VoidrandomnumberthingProcedure {
	public static String execute(WorldAccess world) {
		return new java.text.DecimalFormat("##").format(MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom);
	}
}
