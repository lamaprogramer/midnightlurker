package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.SpawnRateHandler;
import net.mcreator.midnightlurker.util.WorldUtil;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

public class MidnightLurkerNENaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
		int lurkerNetherSpawnRate = MidnightlurkerMod.CONFIG.getNetherLurkerSpawnRate();
		boolean multiSpawningEnabled = MidnightlurkerMod.CONFIG.shouldDoMultiSpawning();

		if (SpawnRateHandler.shouldSpawn(lurkerNetherSpawnRate) && multiSpawningEnabled && WorldUtil.isInDimension(world, DimensionTypes.THE_NETHER)) {
			return true;
		}

        return SpawnRateHandler.shouldSpawn(lurkerNetherSpawnRate) && !multiSpawningEnabled
                && (world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
                && WorldUtil.isInDimension(world, DimensionTypes.THE_NETHER);
    }
}
