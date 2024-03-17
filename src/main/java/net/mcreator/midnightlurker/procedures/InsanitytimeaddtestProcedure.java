package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InsanitytimeaddtestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
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
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity instanceof PlayerEntity) {
						{
							double _setval = 5900;
							IEntityDataSaver entityDataSaver = (IEntityDataSaver)entity;
							entityDataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							entityDataSaver.syncPlayerVariables(entity);
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity instanceof PlayerEntity) {
						{
							double _setval = 11900;
							IEntityDataSaver entityDataSaver = (IEntityDataSaver)entity;
							entityDataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							entityDataSaver.syncPlayerVariables(entity);
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity instanceof PlayerEntity) {
						{
							double _setval = 23900;
							IEntityDataSaver entityDataSaver = (IEntityDataSaver)entity;
							entityDataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							entityDataSaver.syncPlayerVariables(entity);
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity instanceof PlayerEntity) {
						{
							double _setval = 35900;
							IEntityDataSaver entityDataSaver = (IEntityDataSaver)entity;
							entityDataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							entityDataSaver.syncPlayerVariables(entity);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
