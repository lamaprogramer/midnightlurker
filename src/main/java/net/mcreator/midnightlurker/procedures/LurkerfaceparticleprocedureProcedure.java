package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class LurkerfaceparticleprocedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
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
				if (mainjsonobject.get("insanity_progress_effect").getAsBoolean() == true) {
					if (entity instanceof Player && entity.getPersistentData().getDouble("InsanityTimer") <= 200
							&& (entity.getPersistentData().getDouble("InsanityStage") == 1 || entity.getPersistentData().getDouble("InsanityStage") == 2 || entity.getPersistentData().getDouble("InsanityStage") == 3
									|| entity.getPersistentData().getDouble("InsanityStage") == 4 || entity.getPersistentData().getDouble("InsanityStage") == 5 || entity.getPersistentData().getDouble("InsanityStage") == 6)
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && entity.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 55, 0, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES.get(), 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getPersistentData().getDouble("InsanityTimer") > 4800 && entity.getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && entity.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES.get(), 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getPersistentData().getDouble("InsanityTimer") > 10800 && entity.getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && entity.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES.get(), 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getPersistentData().getDouble("InsanityTimer") > 22800 && entity.getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && entity.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES.get(), 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getPersistentData().getDouble("InsanityTimer") > 34800 && entity.getPersistentData().getDouble("InsanityStage") == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1 && entity.getPersistentData().getDouble("InsanityAktive") == 1) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES.get(), 55, 0, false, false));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
