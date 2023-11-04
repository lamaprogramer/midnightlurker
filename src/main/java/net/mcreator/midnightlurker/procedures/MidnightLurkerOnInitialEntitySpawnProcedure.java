package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mushroom_fields"))) {
			MidnightlurkerMod.queueServerWork(1, () -> {
				if (!entity.level.isClientSide())
					entity.discard();
			});
		}
	}
}
