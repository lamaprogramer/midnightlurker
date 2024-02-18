package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

public class MidnightLurkerStareOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		String found_entity_name = "";
		boolean entity_found = false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getPersistentData().getDouble("StareCountdown") == 401) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(100, () -> {
				if (entity.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesOfClass(MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
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
				if (entity instanceof MidnightLurkerStareEntity) {
					((MidnightLurkerStareEntity) entity).setAnimation("teleport9");
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
		if (entity.getPersistentData().getDouble("StareCountdown") >= 401) {
			entity.getPersistentData().putDouble("Staringat", 0);
		}
		if (entity.getPersistentData().getDouble("Staringat") == 1) {
			entity.setShiftKeyDown(true);
		} else if (entity.getPersistentData().getDouble("Staringat") == 0) {
			entity.setShiftKeyDown(false);
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
			if ((entity.getDirection()) == Direction.SOUTH && (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getDirection()) == Direction.NORTH
					|| (entity.getDirection()) == Direction.NORTH && (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getDirection()) == Direction.SOUTH
					|| (entity.getDirection()) == Direction.EAST && (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getDirection()) == Direction.WEST
					|| (entity.getDirection()) == Direction.WEST && (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getDirection()) == Direction.EAST || (new Object() {
						public Entity func(Entity player, double entityReach) {
							double distance = entityReach * entityReach;
							Vec3 eyePos = player.getEyePosition(1.0f);
							HitResult hitResult = entity.pick(entityReach, 1.0f, false);
							if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
								distance = hitResult.getLocation().distanceToSqr(eyePos);
								double blockReach = 5;
								if (distance > blockReach * blockReach) {
									Vec3 pos = hitResult.getLocation();
									hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
								}
							}
							Vec3 viewVec = player.getViewVector(1.0F);
							Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
							AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
							EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
								return !p_234237_.isSpectator();
							}, distance);
							if (entityhitresult != null) {
								Entity entity1 = entityhitresult.getEntity();
								Vec3 targetPos = entityhitresult.getLocation();
								double distanceToTarget = eyePos.distanceToSqr(targetPos);
								if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
									hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
								} else if (distanceToTarget < distance) {
									hitResult = entityhitresult;
								}
							}
							if (hitResult.getType() == HitResult.Type.ENTITY) {
								return ((EntityHitResult) hitResult).getEntity();
							}
							return null;
						}
					}.func(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)), 70)) instanceof MidnightLurkerStareEntity) {
				if (entity.getPersistentData().getDouble("StareCountdown") < 401) {
					entity.getPersistentData().putDouble("StareCountdown", (entity.getPersistentData().getDouble("StareCountdown") + 1));
				}
				if (entity.getPersistentData().getDouble("StareCountdown") <= 400) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 255, false, false));
					entity.getPersistentData().putDouble("Staringat", 1);
				} else if (entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getPersistentData().getDouble("StareCountdown") == 401) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				}
			} else {
				entity.getPersistentData().putDouble("Staringat", 0);
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())));
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && !(world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, (entity.getDeltaMovement().z())));
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && !(world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, (entity.getDeltaMovement().z())));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && !(world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).is(BlockTags.create(new ResourceLocation("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && !(world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).is(BlockTags.create(new ResourceLocation("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.2, (-0.2)));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
			if ((new Object() {
				public Entity func(Entity player, double entityReach) {
					double distance = entityReach * entityReach;
					Vec3 eyePos = player.getEyePosition(1.0f);
					HitResult hitResult = entity.pick(entityReach, 1.0f, false);
					if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
						distance = hitResult.getLocation().distanceToSqr(eyePos);
						double blockReach = 5;
						if (distance > blockReach * blockReach) {
							Vec3 pos = hitResult.getLocation();
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
						}
					}
					Vec3 viewVec = player.getViewVector(1.0F);
					Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
					AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
					EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
						return !p_234237_.isSpectator();
					}, distance);
					if (entityhitresult != null) {
						Entity entity1 = entityhitresult.getEntity();
						Vec3 targetPos = entityhitresult.getLocation();
						double distanceToTarget = eyePos.distanceToSqr(targetPos);
						if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(entity, 80)) == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
				if (entity.getPersistentData().getDouble("CaveSoundLurk") < 300) {
					entity.getPersistentData().putDouble("CaveSoundLurk", (entity.getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (entity.getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.7");
				}
			}
		}
	}
}
