package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MidnightLurkerAggressiveEntityIsHurtProcedure {
	public static boolean execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return true;
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
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean()) {
					if ((entity instanceof MidnightLurkerAggressiveEntity || entity instanceof MidnightLurkerBackturnedEntity || entity instanceof MidnightLurkerHiderEntity || entity instanceof MidnightLurkerRuntrueEntity
							|| entity instanceof MidnightLurkerSeenAngressiveEntity || entity instanceof MidnightLurkerStalkingEntity || entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity)
							&& sourceentity instanceof PlayerEntity) {
						return false;
					}
				} else if (!mainjsonobject.get("lurker_invulnerable").getAsBoolean()) {
					if ((entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity) && sourceentity instanceof PlayerEntity) {
						if (!((IEntityDataSaver) entity).getPersistentData().getBoolean("Stunned")) {
							((IEntityDataSaver)entity).getPersistentData().putBoolean("Stunned", true);
						}
						if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") > 0) {
							return false;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
