package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
public class ShowJump3Stage2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (entity.getPersistentData().getDouble("JumpscareActive") == 1 && entity.getPersistentData().getDouble("InsanityStage") == 2 && entity.getPersistentData().getDouble("JumpscareRandom") == 2) {
			return true;
		}
		return false;
	}
}
