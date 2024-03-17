package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;

public class ShapeshiftermoveindoorsatnightProcedure {
	public static boolean execute(WorldAccess world) {
        return !(world instanceof World _lvl0 && _lvl0.isDay());
    }
}
