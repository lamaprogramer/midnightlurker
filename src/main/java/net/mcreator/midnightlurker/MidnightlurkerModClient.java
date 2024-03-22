package net.mcreator.midnightlurker;

import com.google.gson.Gson;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.client.screens.LurkStatic1Overlay;
import net.mcreator.midnightlurker.client.screens.LurkStatic2Overlay;
import net.mcreator.midnightlurker.init.MidnightlurkerHudRenders;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntityRenderers;
import net.mcreator.midnightlurker.init.MidnightlurkerModModels;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticles;
import net.mcreator.midnightlurker.procedures.LurkerconfigProcedure;

import java.io.*;
import java.nio.file.Files;

public class MidnightlurkerModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //File config = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
        LurkerconfigProcedure.execute();
        MidnightlurkerHudRenders.init();
        MidnightlurkerModEntityRenderers.init();
        MidnightlurkerModModels.init();
        MidnightlurkerModParticles.init();
    }
}
