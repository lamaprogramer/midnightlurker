package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SetinsanitycommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			entity.getPersistentData().putDouble("InsanityStage", 0);
		}
	}
}
