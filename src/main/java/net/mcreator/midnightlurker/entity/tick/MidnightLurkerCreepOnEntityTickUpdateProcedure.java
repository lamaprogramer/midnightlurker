package net.mcreator.midnightlurker.entity.tick;


import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerCreepOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));

		EntityTickActions.handleAutoDismount(entity);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 300)) {
			spawnx = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getX() + MathHelper.nextInt(Random.create(), -10, 10);
			spawny = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getY() + MathHelper.nextInt(Random.create(), -2, 2);
			spawnz = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getZ() + MathHelper.nextInt(Random.create(), -10, 10);
		}

		if (world.isAir(BlockPos.ofFloored(spawnx, spawny + 0, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 2, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 3, spawnz))
				&& !world.isAir(BlockPos.ofFloored(spawnx, spawny - 1, spawnz))) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 300) && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
				if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasStatusEffect(StatusEffects.INVISIBILITY)) {
					{
                        entity.teleport((ServerWorld) world, spawnx, spawny, spawnz, null, entity.getPitch(), entity.getYaw());
						if (entity instanceof ServerPlayerEntity _serverPlayer)
							_serverPlayer.networkHandler.requestTeleport(spawnx, spawny, spawnz, entity.getYaw(), entity.getPitch());
					}
				}
			}
		}
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		handleDisalol(world, entity, entityData, x, y, z);
		handleCreepDespawn(world, entity, entityData, x ,y ,z);
		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		handleEncounter(world, entity, entityData, x ,y ,z);
		handleInvisLogic(world, entity, entityData, x ,y ,z);
	}
	
	public static void handleDisalol(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY)) {
			if (entityData.getPersistentData().getDouble("Disalol") < 2) {
				entityData.getPersistentData().putDouble("Disalol", (entityData.getPersistentData().getDouble("Disalol") + 1));
			}
			
			if (entityData.getPersistentData().getDouble("Disalol") == 1) {
				if (world instanceof ServerWorld level) {
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
				}
				
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
					if (Math.random() > 0.7) {
						if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70) instanceof LivingEntity playerEntity && !playerEntity.getWorld().isClient()) {
							playerEntity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.STATIC_EFFECT, 46, 0, false, false));
						}
					}
				}
			}
			
			if ((livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY) ? livingEntity.getStatusEffect(StatusEffects.INVISIBILITY).getDuration() : 0) == 1) {
				if (world instanceof ServerWorld level) {
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
				}
			}
		}

		if (!(entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY))) {
			if (entityData.getPersistentData().getDouble("Disalol") > 0) {
				entityData.getPersistentData().putDouble("Disalol", 0);
			}
		}
	}

	public static void handleCreepDespawn(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (entityData.getPersistentData().getDouble("CreepDespawn") >= 3) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 4)) {
				if (entityData.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					entityData.getPersistentData().putDouble("SoundActivate", (entityData.getPersistentData().getDouble("SoundActivate") + 1));
				}
				
				if (entityData.getPersistentData().getDouble("SoundActivate") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
					});
				}
				
				if (entity instanceof MidnightLurkerCreepEntity midnightLurkerCreep) {
					midnightLurkerCreep.setAnimation("teleport11");
				}
				
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient()) entity.discard();
				});
			}
		}

		if (entityData.getPersistentData().getDouble("CreepDespawn") <= 2) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 4)) {
				SoundUtil.playsound(world, x, y ,z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
				
				if (!entity.getWorld().isClient()) entity.discard();
				
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

	public static void handleEncounter(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
			if (entityData.getPersistentData().getDouble("encount") < 2) {
				entityData.getPersistentData().putDouble("encount", (entityData.getPersistentData().getDouble("encount") + 1));
			}
		}
		
		if (entityData.getPersistentData().getDouble("encount") == 1) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
				IEntityDataSaver playerEntityData = ((IEntityDataSaver)EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
				if (playerEntityData.getPersistentData().getDouble("encounternumber") < 6) {
					double _setval = playerEntityData.getPersistentData().getDouble("encounternumber") + 1;
					entityData.getPersistentData().putDouble("encounternumber", _setval);
				}
			}
		}
	}

	public static void handleInvisLogic(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 300) && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
			if (!entityData.getPersistentData().getBoolean("InvisLogic")) {
				if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300), entity, 300) instanceof MidnightLurkerCreepEntity) {
					if (entity instanceof MidnightLurkerCreepEntity) {
						((MidnightLurkerCreepEntity) entity).setAnimation("teleport1122");
					}
					MidnightlurkerMod.queueServerWork(13, () -> {
						if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
							livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 25, 0, false, false));
						}
					});
				}
			}
		}
		
		if (entity instanceof LivingEntity livingEntity) {
			entityData.getPersistentData().putBoolean("InvisLogic", livingEntity.hasStatusEffect(StatusEffects.INVISIBILITY));
		}
	}
}
