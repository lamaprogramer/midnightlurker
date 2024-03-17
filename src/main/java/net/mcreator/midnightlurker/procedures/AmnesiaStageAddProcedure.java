package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class AmnesiaStageAddProcedure {
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
				if (mainjsonobject.get("amnesia").getAsBoolean()) {
					if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.AMNESIA, 3, 0, false, false));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
