package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
			SoundUtil.playsound(world, x, y ,z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);

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

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
	}
}
