package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;

public class LurkerKillAnimalsProcProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
