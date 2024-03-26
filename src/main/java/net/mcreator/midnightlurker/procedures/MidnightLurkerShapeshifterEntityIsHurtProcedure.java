package net.mcreator.midnightlurker.procedures;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class MidnightLurkerShapeshifterEntityIsHurtProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.3, 1.5, 0.3, 0.01);
			if (!entity.getWorld().isClient())
				entity.discard();
			if (world instanceof ServerWorld _level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNTRUE.spawn(_level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
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
