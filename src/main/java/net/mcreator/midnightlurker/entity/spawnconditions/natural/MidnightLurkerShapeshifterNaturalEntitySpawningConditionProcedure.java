package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.block.Blocks;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		boolean found = false;
		double sx;
		double sy;
		double sz;
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, VillagerEntity.class, new Vec3d(x, y, z), 40)) {
			sx = -30;
            for (int index0 = 0; index0 < 60; index0++) {
				sy = -30;
				for (int index1 = 0; index1 < 60; index1++) {
					sz = -30;
					for (int index2 = 0; index2 < 60; index2++) {
						if ((world.getBlockState(BlockPos.ofFloored(x + sx, y + sy, z + sz))).getBlock() == Blocks.BELL) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found) {
                return EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerShapeshifterEntity.class, new Vec3d(x, y, z), 400);
			}
		}
		return false;
	}
}
