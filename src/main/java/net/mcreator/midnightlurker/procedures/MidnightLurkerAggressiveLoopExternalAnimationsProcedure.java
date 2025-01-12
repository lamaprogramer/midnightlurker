package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveLoopExternalAnimationsProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15) && (entity.getHorizontalFacing()) == Direction.EAST) {
			if (entity.getVelocity().y == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15) && (entity.getHorizontalFacing()) == Direction.WEST) {
			if (entity.getVelocity().y == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15) && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			if (entity.getVelocity().y == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque()
				&& EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15) && (entity.getHorizontalFacing()) == Direction.NORTH) {
			if (entity.getVelocity().y == 0.2) {
				return true;
			}
		}
		if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
            return entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0;
		}
		return false;
	}
}
