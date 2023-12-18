package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class DestroytexOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double getblockx = 0;
		double getblocky = 0;
		double getblockz = 0;
		BlockState blockz = Blocks.AIR.defaultBlockState();
		BlockState blocky = Blocks.AIR.defaultBlockState();
		BlockState blockx = Blocks.AIR.defaultBlockState();
		MidnightlurkerMod.queueServerWork(20, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
