package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerShapeshifterRightClickedOnEntityProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			if (world instanceof ServerWorld level)
				level.spawnParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.3, 1.5, 0.3, 0.01);

			if (!entity.getWorld().isClient())
				entity.discard();

			if (world instanceof ServerWorld level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYaw(entity.getYaw());
					entityToSpawn.setBodyYaw(entity.getYaw());
					entityToSpawn.setHeadYaw(entity.getYaw());
					entityToSpawn.setPitch(entity.getPitch());
				}
			}
		}
	}
}
