package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;


public class LurkerconfigProcedure {
	public static void execute() {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		if (!lurker.exists()) {
			try {
				lurker.getParentFile().mkdirs();
				lurker.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainjsonobject.addProperty("lurker_chase_music", false);
			mainjsonobject.addProperty("lurker_spawn_rate", 3);
			mainjsonobject.addProperty("the spawn rate can range from 1 to 5, with 1 being the lowest and 5 being the highest.", 0);
			mainjsonobject.addProperty("pop_up_jumpscare", true);
			mainjsonobject.addProperty("jumpscare_sound", true);
			mainjsonobject.addProperty("longer_lurker_chase", false);
			mainjsonobject.addProperty("spooky_ambience", true);
			mainjsonobject.addProperty("multi_spawning", false);
			mainjsonobject.addProperty("insanity_progress_effect", true);
			mainjsonobject.addProperty("insanity_countdown_time", 3);
			mainjsonobject.addProperty("the insanity countdown time determines how long the timer is for insanity. 1 is 5mins, 2 is 10mins, 3 is 20mins, and 4 is 30mins.", 0);
			mainjsonobject.addProperty("lurker_invulnerable", false);
			mainjsonobject.addProperty("nether_lurker_spawn_rate", 4);
			mainjsonobject.addProperty("the nether spawn rate can range from 1 to 5, with 1 being the lowest and 5 being the highest.", 0);
			mainjsonobject.addProperty("amnesia", true);
			mainjsonobject.addProperty("invisible_entities_spawning", true);
			mainjsonobject.addProperty("encounters_progress_stages", true);
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
				if (lurker.exists() && !mainjsonobject.has("lurker_invulnerable")) {
					mainjsonobject.addProperty("lurker_invulnerable", false);
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
				if (lurker.exists() && !mainjsonobject.has("nether_lurker_spawn_rate")) {
					mainjsonobject.addProperty("nether_lurker_spawn_rate", 5);
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
				if (lurker.exists() && !mainjsonobject.has("the nether spawn rate can range from 1 to 5, with 1 being the lowest and 5 being the highest.")) {
					mainjsonobject.addProperty("the nether spawn rate can range from 1 to 5, with 1 being the lowest and 5 being the highest.", 0);
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
				if (lurker.exists() && !mainjsonobject.has("amnesia")) {
					mainjsonobject.addProperty("amnesia", true);
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
				if (lurker.exists() && !mainjsonobject.has("invisible_entities_spawning")) {
					mainjsonobject.addProperty("invisible_entities_spawning", true);
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
				if (lurker.exists() && !mainjsonobject.has("encounters_progress_stages")) {
					mainjsonobject.addProperty("encounters_progress_stages", true);
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
