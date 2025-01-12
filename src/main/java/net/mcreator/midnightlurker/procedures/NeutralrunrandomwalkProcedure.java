package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class NeutralrunrandomwalkProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom < 6 && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 16, 16, 16), e -> true).isEmpty());
    }
}
