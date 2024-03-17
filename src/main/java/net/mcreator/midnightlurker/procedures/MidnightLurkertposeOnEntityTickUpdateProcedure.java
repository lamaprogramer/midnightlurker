package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkertposeOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
			if (!entity.getWorld().isClient())
				entity.discard();

			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
				{
					double _setval = 1;
					dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
					dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
				}
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
	}
}
