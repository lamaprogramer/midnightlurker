package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveCrawlingLoopExternalAnimationsProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8) && (entity.getHorizontalFacing()) == Direction.EAST) {
            return entity.getVelocity().y == 0.2;
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8) && (entity.getHorizontalFacing()) == Direction.WEST) {
            return entity.getVelocity().y == 0.2;
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8) && (entity.getHorizontalFacing()) == Direction.SOUTH) {
            return entity.getVelocity().y == 0.2;
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8) && (entity.getHorizontalFacing()) == Direction.NORTH) {
            return entity.getVelocity().y == 0.2;
		}
		return false;
	}
}
