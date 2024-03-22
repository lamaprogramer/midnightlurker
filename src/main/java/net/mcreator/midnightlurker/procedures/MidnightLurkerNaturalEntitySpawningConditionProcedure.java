package net.mcreator.midnightlurker.procedures;

import net.minecraft.registry.Registries;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

public class MidnightLurkerNaturalEntitySpawningConditionProcedure {
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
				if (mainjsonobject.get("multi_spawning").getAsBoolean()) {
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
		if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.9 && (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.8
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.6
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() && Math.random() >= 0.4
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() && (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
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
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
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
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && !mainjsonobject.get("multi_spawning").getAsBoolean()
				&& (world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
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
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4
				&& (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
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
				&& (world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) && (world instanceof World _lvl ? _lvl.getDimensionKey() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD) {
			return true;
		}
		return false;
	}
}
