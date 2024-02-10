package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerRuntrueOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(400, () -> {
				if (entity.getPersistentData().getDouble("SoundActivate2") < 3 && !world.getEntitiesOfClass(MidnightLurkerRuntrueEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("SoundActivate2", (entity.getPersistentData().getDouble("SoundActivate2") + 1));
				}
				if (entity.getPersistentData().getDouble("SoundActivate2") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerRuntrueEntity) {
					((MidnightLurkerRuntrueEntity) entity).setAnimation("teleport6");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		}
	}
}
