package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MidnightLurkerFakerWatcherNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				}
				if (!mainjsonobject.get("multi_spawning").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("multi_spawning").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 1000, 1000, 1000);
		if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.9 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.8 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.6 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.4 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		}
		if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4 && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
            return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && !world.isSkyVisibleAllowingSea(BlockPos.ofFloored(x, y, z))
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return dataSaver.getPersistentData().getDouble("InsanityStage") == 6;
		}
		return false;
	}
}
