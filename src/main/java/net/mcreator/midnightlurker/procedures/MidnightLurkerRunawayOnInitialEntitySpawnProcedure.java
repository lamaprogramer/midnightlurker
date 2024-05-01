package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerRunawayOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.ofFloored(x, y, z)).matchesKey(BiomeKeys.MUSHROOM_FIELDS)) {
			MidnightlurkerMod.queueServerWork(1, () -> {
				if (!entity.getWorld().isClient())
					entity.discard();
			});
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 99999, 250, false, false));
		MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom = MathHelper.nextDouble(Random.create(), 1, 10);
		MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive < 1) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300);
		if (dataSaver.getPersistentData().getDouble("InsanityAktive") < 1) {
			{
				double _setval = 1;
				dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
				dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300));
			}
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 1, false, false));
		}
	}
}
