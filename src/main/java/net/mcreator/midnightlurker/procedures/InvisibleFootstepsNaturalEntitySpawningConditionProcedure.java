package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.*;
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

public class InvisibleFootstepsNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
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
				if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (!mainjsonobject.get("invisible_entities_spawning").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!mainjsonobject.get("invisible_entities_spawning").getAsBoolean()) {
			return false;
		} else if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean()) {
            return world.getEntitiesByClass(InvisibleFootstepsEntity.class, Box.of(new Vec3d(x, y, z), 800, 800, 800), e -> true).isEmpty()
                    && world.getEntitiesByClass(InvisibleShadowEntity.class, Box.of(new Vec3d(x, y, z), 800, 800, 800), e -> true).isEmpty()
                    && world.getEntitiesByClass(InvisibleStaticEntity.class, Box.of(new Vec3d(x, y, z), 800, 800, 800), e -> true).isEmpty()
                    && world.getEntitiesByClass(InvisibleLurkerFootstepsEntity.class, Box.of(new Vec3d(x, y, z), 800, 800, 800), e -> true).isEmpty()
                    && world.getEntitiesByClass(InvisibleCaveSoundsEntity.class, Box.of(new Vec3d(x, y, z), 800, 800, 800), e -> true).isEmpty() && (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD;
		}
		return false;
	}
}
