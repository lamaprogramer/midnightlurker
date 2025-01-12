package net.mcreator.midnightlurker.entity.spawnconditions.init;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerNeutralOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.MUSHROOM_FIELDS)) {
			if (!entity.getWorld().isClient()) entity.discard();
		}

		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive < 1) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}

		IEntityDataSaver entityData = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300);
		if (entityData.getPersistentData().getDouble("InsanityAktive") < 1) {
			entityData.getPersistentData().putDouble("InsanityAktive", 1);
		}

		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
				livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 1, false, false));
			}
		}
	}
}
