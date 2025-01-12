package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

public class MidnightLurkerFakerSpawnmainProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);

		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 1000, 1000, 1000);
		int lurkerSpawnRate = MidnightlurkerMod.CONFIG.getLurkerSpawnRate();
		boolean multiSpawningEnabled = MidnightlurkerMod.CONFIG.shouldDoMultiSpawning();
		double insanityStage = dataSaver.getPersistentData().getDouble("InsanityStage");

		if (SpawnRateHandler.shouldSpawn(lurkerSpawnRate) && multiSpawningEnabled
				&& !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 1000)
				&& WorldUtil.isInDimension(world, DimensionTypes.OVERWORLD)) {
			return insanityStage == 6;
		}


		if (SpawnRateHandler.shouldSpawn(lurkerSpawnRate) && !multiSpawningEnabled
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerInvisibleEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerSeenAngressiveEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerStalkingEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerBackturnedEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerHiderEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerRunawayEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerShapeshifterEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerUnprovokedEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkertposeEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerStareEntity.class, new Vec3d(x, y, z), 700)
				&& EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerWatcherEntity.class, new Vec3d(x, y, z), 700)
				&& (EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 1000)) && WorldUtil.isInDimension(world, DimensionTypes.OVERWORLD)) {
            return insanityStage == 6;
		}
		return false;
	}
}
