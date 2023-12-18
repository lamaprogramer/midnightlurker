package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JumpscarerFrame25Procedure {
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
		if (entity.getPersistentData().getDouble("JumpscareTimer") == 15 && entity.getPersistentData().getDouble("JumpscareActive") == 1) {
			return true;
		} else if (entity.getPersistentData().getDouble("JumpscareTimer") == 5 && entity.getPersistentData().getDouble("JumpscareActive") == 1) {
			return true;
		}
		return false;
	}
}
