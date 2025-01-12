package net.mcreator.midnightlurker.entity.spawnconditions.init;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerRuntrueOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.MUSHROOM_FIELDS)) {
			if (!entity.getWorld().isClient()) entity.discard();
		}

		if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
			livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 99999, 250, false, false));
		}

		MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom = MathHelper.nextDouble(Random.create(), 1, 10);
		MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
				livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 1, false, false));
			}
		}
	}
}
