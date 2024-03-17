package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class NeutralrunrandomrunawayProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom > 5) {
			return true;
		} else return !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 13, 13, 13), e -> true).isEmpty();
    }
}
