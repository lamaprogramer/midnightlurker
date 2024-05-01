package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.WorldAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LurkerfaceparticleprocedureProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
                IEntityDataSaver dataSaver = (IEntityDataSaver) entity; 
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("insanity_progress_effect").getAsBoolean()) {
					if (entity instanceof PlayerEntity && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") <= 200
							&& (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 1
									|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 2
									|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 3
									|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 4
									|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 5
									|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6)
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity instanceof PlayerEntity && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 4800
							&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity instanceof PlayerEntity && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 10800
							&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity instanceof PlayerEntity && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 22800
							&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity instanceof PlayerEntity && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 34800
							&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
