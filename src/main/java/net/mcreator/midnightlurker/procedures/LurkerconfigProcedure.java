package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LurkerconfigProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "lurkerconfig.json");
		if (!lurker.exists()) {
			try {
				lurker.getParentFile().mkdirs();
				lurker.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainjsonobject.addProperty("lurker_chase_music", true);
			mainjsonobject.addProperty("lurker_low_spawn_rate", true);
			mainjsonobject.addProperty("pop_up_jumpscare", true);
			mainjsonobject.addProperty("jumpscare_sound", true);
			mainjsonobject.addProperty("blindness_in_chase", false);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(lurker);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainjsonobject));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
