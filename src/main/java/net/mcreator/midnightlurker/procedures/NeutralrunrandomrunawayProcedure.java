package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class NeutralrunrandomrunawayProcedure {
	public static boolean execute(LevelAccessor world) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom > 5) {
			return true;
		}
		return false;
	}
}
