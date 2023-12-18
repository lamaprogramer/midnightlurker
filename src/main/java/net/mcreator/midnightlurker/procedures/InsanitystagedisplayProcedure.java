package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InsanitystagedisplayProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level);
		}
	}

	public static String execute(LevelAccessor world) {
		return execute(null, world);
	}

	private static String execute(@Nullable Event event, LevelAccessor world) {
		return new java.text.DecimalFormat("#").format(MidnightlurkerModVariables.WorldVariables.get(world).insanitystagedisplaylol) + "";
	}
}
