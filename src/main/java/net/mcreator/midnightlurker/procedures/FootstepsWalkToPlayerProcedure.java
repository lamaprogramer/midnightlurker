package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
public class FootstepsWalkToPlayerProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 7, 7, 7), e -> true).isEmpty();
    }
}
