package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

public class StarewatchProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
        return ((IEntityDataSaver) entity).getPersistentData().getDouble("StareCountdown") <= 400 && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 30, 30, 30), e -> true).isEmpty());
    }
}
