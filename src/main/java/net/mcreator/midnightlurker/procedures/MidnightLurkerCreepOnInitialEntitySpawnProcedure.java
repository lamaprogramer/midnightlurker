package net.mcreator.midnightlurker.procedures;

import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerCreepOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.MUSHROOM_FIELDS)) {
			
			MidnightlurkerMod.queueServerWork(1, () -> {
				if (!entity.getWorld().isClient())
					entity.discard();
			});
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 1, false, false));
		}
		((IEntityDataSaver)entity).getPersistentData().putDouble("CreepDespawn", (MathHelper.nextInt(Random.create(), 0, 5)));
	}
}