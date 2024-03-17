package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class EncounterProcProcedure {
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
				if (mainjsonobject.get("encounters_progress_stages").getAsBoolean()) {
                    IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
					if (dataSaver.getPersistentData().getDouble("encounternumber") >= 6) {

                        dataSaver.getPersistentData().putDouble("encounternumber", 0);
                        dataSaver.syncPlayerVariables(entity);

						if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {

                            double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
                            dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                            dataSaver.syncPlayerVariables(entity);

                            dataSaver.getPersistentData().putDouble("InsanityTimer", 0);
                            dataSaver.syncPlayerVariables(entity);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
