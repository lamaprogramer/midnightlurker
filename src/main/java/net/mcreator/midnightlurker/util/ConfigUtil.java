package net.mcreator.midnightlurker.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConfigUtil {
    public static JsonObject loadConfig() {
        File lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
        JsonObject mainjsonobject;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
            StringBuilder jsonstringbuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonstringbuilder.append(line);
            }
            bufferedReader.close();
            mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
            return mainjsonobject;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
