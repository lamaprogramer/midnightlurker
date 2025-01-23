package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class InvisibleShadowOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x ,y, z), 9)) {
			if (!entity.getWorld().isClient()) entity.discard();
		}
	}
}
