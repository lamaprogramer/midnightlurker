package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import java.io.File;

public class MidnightLurkerNENaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		return (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.NETHER && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.END;
	}
}
