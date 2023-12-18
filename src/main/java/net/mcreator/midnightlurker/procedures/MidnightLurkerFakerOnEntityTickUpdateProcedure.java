package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.File;

public class MidnightLurkerFakerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if (entity.getPersistentData().getDouble("PlayerActivation") <= 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
			entity.getPersistentData().putDouble("PlayerActivation", (entity.getPersistentData().getDouble("PlayerActivation") + 1));
		}
		if (entity.getPersistentData().getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof MidnightLurkerFakerEntity && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false)) {
				if (entity instanceof MidnightLurkerFakerEntity) {
					((MidnightLurkerFakerEntity) entity).setAnimation("snapstare4");
				}
				if (entity instanceof LivingEntity _entity)
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
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false)) {
			entity.getPersistentData().putDouble("SlownessEffect", (entity.getPersistentData().getDouble("SlownessEffect") + 1));
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0 && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false)
				&& entity.getPersistentData().getDouble("PlayerActivation") <= 0) {
			entity.getPersistentData().putDouble("SlownessEffect", 0);
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 255, false, false));
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (world.getBlockState(new BlockPos(x + 1, y + 0, z)).canOcclude() && (!world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || !world.getBlockState(new BlockPos(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, 0));
		} else if (world.getBlockState(new BlockPos(x - 1, y + 0, z)).canOcclude() && (!world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || !world.getBlockState(new BlockPos(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, 0));
		} else if (world.getBlockState(new BlockPos(x, y + 0, z + 1)).canOcclude() && (!world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || !world.getBlockState(new BlockPos(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, 0.2));
		} else if (world.getBlockState(new BlockPos(x, y + 0, z - 1)).canOcclude() && (!world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || !world.getBlockState(new BlockPos(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, (-0.2)));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (!entity.level.isClientSide())
				entity.discard();
			if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("JumpscareActive") < 1) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().putDouble("JumpscareActive", 1);
			}
			if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("InsanityStage") < 7) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().putDouble("InsanityStage",
						(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("InsanityStage") + 1));
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().putDouble("InsanityTimer", 0);
			}
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") >= 1 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()
				&& entity.getPersistentData().getDouble("PlayerActivation") >= 1) {
			if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 50, 50, 50), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 55, 0, false, false));
		}
		if (entity.getPersistentData().getDouble("SlownessEffect") <= 0 && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
			entity.setShiftKeyDown(true);
		} else if (entity.getPersistentData().getDouble("SlownessEffect") >= 1 && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
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
