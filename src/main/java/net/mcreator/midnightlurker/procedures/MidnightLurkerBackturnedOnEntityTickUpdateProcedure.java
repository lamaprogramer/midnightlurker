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
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerBackturnedOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("PlayerActivation") <= 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 60, 60, 60), e -> true).isEmpty()) {
			entity.getPersistentData().putDouble("PlayerActivation", (entity.getPersistentData().getDouble("PlayerActivation") + 1));
		}
		if (entity.getPersistentData().getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof MidnightLurkerBackturnedEntity && !(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()))) {
				if (entity instanceof MidnightLurkerBackturnedEntity) {
					((MidnightLurkerBackturnedEntity) entity).setAnimation("snapstare5");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 80, 0, false, false));
			}
		}
		if (entity.getPersistentData().getDouble("PlayerActivation") >= 1) {
			if (entity.getPersistentData().getDouble("InsanePotionTimer") < 2) {
				entity.getPersistentData().putDouble("InsanePotionTimer", (entity.getPersistentData().getDouble("InsanePotionTimer") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") < 1 && entity.getPersistentData().getDouble("PlayerActivation") >= 1
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) <= 1
				&& entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			entity.getPersistentData().putDouble("SlownessEffect", (entity.getPersistentData().getDouble("SlownessEffect") + 1));
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0 && !(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()))
				&& entity.getPersistentData().getDouble("PlayerActivation") <= 0) {
			entity.getPersistentData().putDouble("SlownessEffect", 0);
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 255, false, false));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, (-0.2)));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(700, () -> {
				if (entity.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesOfClass(MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("SoundActivate", (entity.getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (entity.getPersistentData().getDouble("SoundActivate") == 1) {
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
				if (entity instanceof MidnightLurkerBackturnedEntity) {
					((MidnightLurkerBackturnedEntity) entity).setAnimation("teleport5");
				}
				MidnightlurkerMod.queueServerWork(14, () -> {
					if (!entity.level.isClientSide())
						entity.discard();
				});
			});
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0 && entity instanceof LivingEntity _livEnt78 && _livEnt78.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			entity.setShiftKeyDown(true);
		} else if (entity.getPersistentData().getDouble("SlownessEffect") >= 1 && entity instanceof LivingEntity _livEnt81 && _livEnt81.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			MidnightlurkerMod.queueServerWork(2, () -> {
				entity.setShiftKeyDown(false);
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
	}
}
