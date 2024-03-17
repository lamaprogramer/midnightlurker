package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressivePlayReturnedAnimationProcedure {
	public static String execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.EAST) {
			if (entity.getVelocity().y == 0.2) {
				return "climb1";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.WEST) {
			if (entity.getVelocity().y == 0.2) {
				return "climb1";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			if (entity.getVelocity().y == 0.2) {
				return "climb1";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.NORTH) {
			if (entity.getVelocity().y == 0.2) {
				return "climb1";
			}
		}
		if (!world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && (entity.getHorizontalFacing()) == Direction.EAST
				|| !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque()
						&& (entity.getHorizontalFacing()) == Direction.EAST
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running3";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && (entity.getHorizontalFacing()) == Direction.WEST
				|| !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque()
						&& (entity.getHorizontalFacing()) == Direction.WEST
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running3";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && (entity.getHorizontalFacing()) == Direction.SOUTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque()
						&& (entity.getHorizontalFacing()) == Direction.SOUTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running3";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && (entity.getHorizontalFacing()) == Direction.NORTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque()
						&& (entity.getHorizontalFacing()) == Direction.NORTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running3";
			}
		}
		if (!world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque()
				&& (entity.getHorizontalFacing()) == Direction.EAST
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running2";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque()
				&& (entity.getHorizontalFacing()) == Direction.WEST
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running2";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque()
				&& (entity.getHorizontalFacing()) == Direction.SOUTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running2";
			}
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque()
				&& (entity.getHorizontalFacing()) == Direction.NORTH
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))) {
			if (entity.getVelocity().z > 0 || entity.getVelocity().x > 0 || entity.getVelocity().z < 0 || entity.getVelocity().x < 0) {
				return "running2";
			}
		}
		return "empty";
	}
}
