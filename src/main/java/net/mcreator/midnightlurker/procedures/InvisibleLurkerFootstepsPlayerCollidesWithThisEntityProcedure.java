package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class InvisibleLurkerFootstepsPlayerCollidesWithThisEntityProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
			if (!entity.getWorld().isClient()) {
				entity.discard();
			}
		}
	}
}
