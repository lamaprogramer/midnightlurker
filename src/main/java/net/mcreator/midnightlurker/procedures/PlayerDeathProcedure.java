package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.network.MidnightLurkerNetworking;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class PlayerDeathProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;

        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (entity instanceof PlayerEntity) {
			dataSaver.getPersistentData().putDouble("InsanityAktive", 0);
		}

		if (entity instanceof PlayerEntity player && !world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("DeathJumpActive") < 1) {
				dataSaver.getPersistentData().putDouble("DeathJumpActive", 1);

				MidnightLurkerNetworking.syncPlayerData((ServerPlayerEntity) player, "DeathJumpActive");
			}
		}
	}
}
