package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
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
import net.minecraft.world.World;
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
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 300, 300, 300), e -> true).isEmpty()) {
			spawnx = EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getX() + MathHelper.nextInt(Random.create(), -10, 10);
			spawny = EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getY() + MathHelper.nextInt(Random.create(), -2, 2);
			spawnz = EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300).getZ() + MathHelper.nextInt(Random.create(), -10, 10);
		}
		if (world.isAir(BlockPos.ofFloored(spawnx, spawny + 0, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 2, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 3, spawnz))
				&& !world.isAir(BlockPos.ofFloored(spawnx, spawny - 1, spawnz))) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 300, 300, 300), e -> true).isEmpty() && world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasStatusEffect(StatusEffects.INVISIBILITY)) {
					{
                        entity.teleport(spawnx, spawny, spawnz);
						if (entity instanceof ServerPlayerEntity _serverPlayer)
							_serverPlayer.networkHandler.requestTeleport(spawnx, spawny, spawnz, entity.getYaw(), entity.getPitch());
					}
				}
			}
		}
		
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasStatusEffect(StatusEffects.INVISIBILITY)) {
			if (dataSaver.getPersistentData().getDouble("Disalol") < 2) {
				dataSaver.getPersistentData().putDouble("Disalol", (dataSaver.getPersistentData().getDouble("Disalol") + 1));
			}
			if (dataSaver.getPersistentData().getDouble("Disalol") == 1) {
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
				if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 70, 70, 70), e -> true).isEmpty()) {
					if (Math.random() > 0.7) {
						if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.STATIC_EFFECT, 46, 0, false, false));
					}
				}
			}
            if ((_livEnt21.hasStatusEffect(StatusEffects.INVISIBILITY) ? _livEnt21.getStatusEffect(StatusEffects.INVISIBILITY).getDuration() : 0) == 1) {
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurkerdisappear neutral @a ~ ~ ~ 1 1");
			}
		}
		if (!(entity instanceof LivingEntity _livEnt32 && _livEnt32.hasStatusEffect(StatusEffects.INVISIBILITY))) {
			if (dataSaver.getPersistentData().getDouble("Disalol") > 0) {
				dataSaver.getPersistentData().putDouble("Disalol", 0);
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 300, 300, 300), e -> true).isEmpty() && world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			if (!((IEntityDataSaver) entity).getPersistentData().getBoolean("InvisLogic")) {
				if (EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 300, 300, 300), entity, 300) instanceof MidnightLurkerCreepEntity) {
					if (entity instanceof MidnightLurkerCreepEntity) {
						((MidnightLurkerCreepEntity) entity).setAnimation("releport1122");
					}
					MidnightlurkerMod.queueServerWork(13, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
							_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 25, 0, false, false));
					});
				}
			}
		}
		if (dataSaver.getPersistentData().getDouble("CreepDespawn") >= 3) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).isEmpty()) {
				if (dataSaver.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					dataSaver.getPersistentData().putDouble("SoundActivate", (dataSaver.getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (dataSaver.getPersistentData().getDouble("SoundActivate") == 1) {
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
				if (entity instanceof MidnightLurkerCreepEntity) {
					((MidnightLurkerCreepEntity) entity).setAnimation("teleport11");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			}
		}
		if (dataSaver.getPersistentData().getDouble("CreepDespawn") <= 2) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).isEmpty()) {
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1, false);
					}
				}
				if (!entity.getWorld().isClient())
					entity.discard();
				if (world instanceof ServerWorld _level) {
					Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(_level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYaw(entity.getYaw());
						entityToSpawn.setBodyYaw(entity.getYaw());
						entityToSpawn.setHeadYaw(entity.getYaw());
						entityToSpawn.setPitch(entity.getPitch());
					}
				}
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("encount") < 2) {
				dataSaver.getPersistentData().putDouble("encount", (dataSaver.getPersistentData().getDouble("encount") + 1));
			}
		}
		if (dataSaver.getPersistentData().getDouble("encount") == 1) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				if (((IEntityDataSaver)EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8)).getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = ((IEntityDataSaver)EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8)).getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt85 && _livEnt85.hasStatusEffect(StatusEffects.INVISIBILITY)) {
			dataSaver.getPersistentData().putBoolean("InvisLogic", true);
		} else if (!(entity instanceof LivingEntity _livEnt87 && _livEnt87.hasStatusEffect(StatusEffects.INVISIBILITY))) {
			dataSaver.getPersistentData().putBoolean("InvisLogic", false);
		}
	}
}
