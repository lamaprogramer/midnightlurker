package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.registry.Registries;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerRuntrueOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(200, () -> {
				IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
				if (dataSaver.getPersistentData().getDouble("SoundActivate2") < 3 && !world.getEntitiesByClass(MidnightLurkerRuntrueEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					dataSaver.getPersistentData().putDouble("SoundActivate2", (dataSaver.getPersistentData().getDouble("SoundActivate2") + 1));
				}
				if (dataSaver.getPersistentData().getDouble("SoundActivate2") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof World _level) {
							if (!_level.isClient()) {
								_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
							} else {
								_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerRuntrueEntity) {
					((MidnightLurkerRuntrueEntity) entity).setAnimation("teleport6");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles((DefaultParticleType) (MidnightlurkerModParticleTypes.VOID_DOT), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasStatusEffect(StatusEffects.SLOWNESS)
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
            _livEnt22.removeStatusEffect(StatusEffects.SLOWNESS);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).hasVehicle()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 255, false, false));
			}
		}
	}
}
