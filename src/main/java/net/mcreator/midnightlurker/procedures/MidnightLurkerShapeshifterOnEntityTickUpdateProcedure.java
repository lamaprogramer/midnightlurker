package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;

public class MidnightLurkerShapeshifterOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifternumber") < 3) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("Shapeshifternumber", (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifternumber") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifternumber") == 1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") < 1) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("Shapeshifterrandom", (MathHelper.nextInt(Random.create(), 1, 3)));
		}
		if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.PLAINS)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsarmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsbutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainslibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.TAIGA)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigaarmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigabutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigalibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SAVANNA)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SAVANNA_PLATEAU)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.WINDSWEPT_SAVANNA)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannaarmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannabutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannalibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.JUNGLE)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.BAMBOO_JUNGLE)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SPARSE_JUNGLE)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglearmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglebutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglelibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.DESERT)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertarmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertbutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertlibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SNOWY_PLAINS)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SNOWY_PLAINS)
				|| world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SNOWY_SLOPES)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowarmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowbutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowlibrarian");
			}
		} else if (world.getBiome(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())).matchesKey(BiomeKeys.SWAMP)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamparmorer");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swampbutcher");
			} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamplibrarian");
			}
		}
	}
}
