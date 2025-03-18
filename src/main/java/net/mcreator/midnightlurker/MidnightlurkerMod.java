/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.midnightlurker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.config.core.ConfigRegistry;
import net.mcreator.midnightlurker.init.*;
import net.mcreator.midnightlurker.network.MidnightLurkerNetworking;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.procedures.TriestosleepwhilemonstersnearProcedure;
import net.minecraft.server.MinecraftServer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MidnightlurkerMod implements ModInitializer {
	public static final String MODID = "midnightlurker";
	public static CoreConfig CONFIG;
	public static final boolean DEBUG_MODE = FabricLoader.getInstance().isDevelopmentEnvironment();

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@Override
	public void onInitialize() {
		CoreConfig defaultConfig = new CoreConfig();
		defaultConfig.setLurkerChaseMusic(true);
		defaultConfig.setLurkerSpawnRate(3);
		defaultConfig.setPopUpJumpscare(true);
		defaultConfig.setJumpscareSound(true);
		defaultConfig.setLongerLurkerChase(false);
		defaultConfig.setSpookyAmbience(true);
		defaultConfig.setMultiSpawning(false);
		defaultConfig.setInsanityProgressEffect(true);
		defaultConfig.setInsanityCountdownTime(3);
		defaultConfig.setLurkerInvulnerable(false);
		defaultConfig.setNetherLurkerSpawnRate(4);
		defaultConfig.setAmnesia(true);
		defaultConfig.setInvisibleEntitiesSpawning(true);
		defaultConfig.setEncountersProgressStages(true);
		defaultConfig.setInsanityBar(true);
		CONFIG = new ConfigRegistry<>(defaultConfig, CoreConfig.class).register();

		MidnightLurkerNetworking.initServer();

		MidnightlurkerModSounds.init();
		MidnightlurkerModItems.init();
		MidnightlurkerModEntities.init();
		MidnightlurkerModParticleTypes.init();
		MidnightlurkerModMobEffects.init();
		MidnightlurkerModTabs.buildTabContentsVanilla();

		MidnightlurkerModVariables.initServer();

		UseBlockCallback.EVENT.register(new TriestosleepwhilemonstersnearProcedure());

		ServerTickEvents.END_SERVER_TICK.register((MinecraftServer server) -> {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		});
	}
}
