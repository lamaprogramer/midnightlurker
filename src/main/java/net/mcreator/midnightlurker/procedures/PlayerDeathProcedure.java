package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class PlayerDeathProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;

        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (entity instanceof PlayerEntity) {
			{
				double _setval = 0;
                dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
                dataSaver.syncPlayerVariables(entity);
			}
		}
		if (entity instanceof PlayerEntity && !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("DeathJumpActive") < 1) {
				{
					double _setval = 1;
                    dataSaver.getPersistentData().putDouble("DeathJumpActive", _setval);
                    dataSaver.syncPlayerVariables(entity);
				}
			}
		}
	}
}
