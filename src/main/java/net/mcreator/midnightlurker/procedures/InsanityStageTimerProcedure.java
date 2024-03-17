package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class InsanityStageTimerProcedure {
    public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
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
                
                IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") < 6001) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityTimer") + 1;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") == 6000
								&& dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
									dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
									dataSaver.syncPlayerVariables(entity);
								}
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityTimer") >= 6001) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") < 90) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityReset") + 1;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityReset") == 89) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityReset") == 90) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
                            dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") > 0) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") < 12001) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityTimer") + 1;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") == 12000
								&& dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
									dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
									dataSaver.syncPlayerVariables(entity);
								}
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityTimer") >= 12001) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") < 90) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityReset") + 1;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityReset") == 89) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityReset") == 90) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
                            dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") > 0) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") < 24001) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityTimer") + 1;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") == 24000
								&& dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityTimer") >= 24001) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") < 90) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityReset") + 1;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityReset") == 89) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityReset") == 90) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
                            dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") > 0) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") < 36001) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityTimer") + 1;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityTimer") == 36000
								&& dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityTimer") >= 36001) {
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") < 90) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityReset") + 1;

								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
						if (dataSaver.getPersistentData().getDouble("InsanityReset") == 89) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityReset") == 90) {
						{
							double _setval = 0;
                            dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
                            dataSaver.syncPlayerVariables(entity);
						}
					}
					if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
							&& !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (dataSaver.getPersistentData().getDouble("InsanityStage") == 7
								&& dataSaver.getPersistentData().getDouble("InsanityReset") > 0) {
							{
								double _setval = 0;
								dataSaver.getPersistentData().putDouble("InsanityReset", _setval);
								dataSaver.syncPlayerVariables(entity);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
