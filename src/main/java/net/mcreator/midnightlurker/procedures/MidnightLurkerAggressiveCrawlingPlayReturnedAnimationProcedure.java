package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;

public class MidnightLurkerAggressiveCrawlingPlayReturnedAnimationProcedure {
	public static String execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.EAST) {
			if (entity.getVelocity().y == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.WEST) {
			if (entity.getVelocity().y == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			if (entity.getVelocity().y == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque()
				&& world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.NORTH) {
			if (entity.getVelocity().y == 0.2) {
				return "climb3";
			}
		}
		return "empty";
	}
}
