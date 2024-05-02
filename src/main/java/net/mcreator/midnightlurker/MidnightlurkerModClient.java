package net.mcreator.midnightlurker;

import net.fabricmc.api.ClientModInitializer;
import net.mcreator.midnightlurker.init.MidnightlurkerHudRenders;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntityRenderers;
import net.mcreator.midnightlurker.init.MidnightlurkerModModels;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticles;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.procedures.LurkerconfigProcedure;

public class MidnightlurkerModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MidnightlurkerModVariables.initClient();
        MidnightlurkerHudRenders.init();
        MidnightlurkerModEntityRenderers.init();
        MidnightlurkerModModels.init();
        MidnightlurkerModParticles.init();
    }
}
