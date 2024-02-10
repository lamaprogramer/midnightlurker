package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

public class MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
			sx = -30;
			found = false;
			for (int index0 = 0; index0 < 60; index0++) {
				sy = -30;
				for (int index1 = 0; index1 < 60; index1++) {
					sz = -30;
					for (int index2 = 0; index2 < 60; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BELL) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == true) {
				if (!(!world.getEntitiesOfClass(MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty())) {
					return true;
				}
			}
		}
		return false;
	}
}
