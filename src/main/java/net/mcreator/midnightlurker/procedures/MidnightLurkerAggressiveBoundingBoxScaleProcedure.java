package net.mcreator.midnightlurker.procedures;

import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveBoundingBoxScaleProcedure {
	public static double execute(WorldAccess world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque() && (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque()
						|| (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z))).isIn(BlockTags.LEAVES)
								&& (world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque() && (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque()
						|| (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z))).isIn(BlockTags.LEAVES)
								&& (world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque() && (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque()
						|| (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1))).isIn(BlockTags.LEAVES)
								&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque() && (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque()
						|| (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1))).isIn(BlockTags.LEAVES)
								&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 1, z))).isIn(BlockTags.LEAVES))) {
			return 0.3;
		}
		if (!world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x + 1, y + 2, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x + 1, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x + 1, y + 3, z)).isOpaque()
								|| (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z))).isIn(BlockTags.LEAVES)
										&& (world.getBlockState(BlockPos.ofFloored(x + 1, y + 3, z))).isIn(BlockTags.LEAVES))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x - 1, y + 2, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x - 1, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x - 1, y + 3, z)).isOpaque()
								|| (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z))).isIn(BlockTags.LEAVES)
										&& (world.getBlockState(BlockPos.ofFloored(x - 1, y + 3, z))).isIn(BlockTags.LEAVES))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 2, z + 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z + 1)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 3, z + 1)).isOpaque()
								|| (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1))).isIn(BlockTags.LEAVES)
										&& (world.getBlockState(BlockPos.ofFloored(x, y + 3, z + 1))).isIn(BlockTags.LEAVES))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque()
				&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 0, z)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || (world.getBlockState(BlockPos.ofFloored(x, y + 2, z))).isIn(BlockTags.LEAVES))
				|| !world.getBlockState(BlockPos.ofFloored(x, y + 2, z - 1)).isOpaque() && !world.getBlockState(BlockPos.ofFloored(x, y + 1, z - 1)).isOpaque()
						&& (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && world.getBlockState(BlockPos.ofFloored(x, y + 3, z - 1)).isOpaque()
								|| (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1))).isIn(BlockTags.LEAVES)
										&& (world.getBlockState(BlockPos.ofFloored(x, y + 3, z - 1))).isIn(BlockTags.LEAVES))) {
			return 0.7;
		}
		return 1;
	}
}
