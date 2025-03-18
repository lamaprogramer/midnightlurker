package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.animations.Animations;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerStalkingOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
			SoundUtil.playsound(world, x, y ,z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
			if (!entity.getWorld().isClient())
				entity.discard();

			if (world instanceof ServerWorld level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(x, y, z), SpawnReason.MOB_SUMMONED);

				if (entityToSpawn != null) {
					entityToSpawn.setVelocity(0, 0, 0);
				}
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 25, 25, 25), e -> true).isEmpty()) {
			EntityTickActions.handleEffect(entity, StatusEffects.SLOWNESS, 60, 255, false, false);
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
			PlayerEntity player = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23);
			Entity stalkerEntity = EntityUtil.getEntityWithRaycast(player, entity, 23);

			if (stalkerEntity instanceof MidnightLurkerStalkingEntity midnightLurkerStalkingEntity) {
				SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

				if (Math.random() > 0.7 && !player.getWorld().isClient()) {
					player.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.STATIC_EFFECT, 46, 0, false, false));
				}

				midnightLurkerStalkingEntity.setAnimation(Animations.TELEPORT_1);

				if (!entity.getWorld().isClient())
					entity.discard();
			}
		}

		EntityTickActions.handleClimbing(world, entity, x, y, z);
	}
}
