package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerUnprovokedOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessCountdown") < 2401 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 70)) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("SlownessCountdown", (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessCountdown") + 1));
		}

		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasStatusEffect(StatusEffects.SLOWNESS) && ((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessCountdown") == 2400) {
            _livEnt7.removeStatusEffect(StatusEffects.SLOWNESS);

		} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasStatusEffect(StatusEffects.SLOWNESS)
				&& !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 20)) {
            _livEnt10.removeStatusEffect(StatusEffects.SLOWNESS);
		}

		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
		EntityTickActions.handleAutoDismount(entity);

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CanDisappear") < 201) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("CanDisappear", (((IEntityDataSaver)entity).getPersistentData().getDouble("CanDisappear") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CanDisappear") >= 200) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 15, 15, 15), e -> true).isEmpty()) {
				MidnightlurkerMod.queueServerWork(700, () -> {
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
						((IEntityDataSaver)entity).getPersistentData().putDouble("SoundActivate", (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") + 1));
					}
					if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate") == 1) {
						MidnightlurkerMod.queueServerWork(2, () -> {
							if (world instanceof World level) {
								if (!level.isClient()) {
									level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
								} else {
									level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
								}
							}
						});
					}
					if (entity instanceof MidnightLurkerUnprovokedEntity) {
						((MidnightLurkerUnprovokedEntity) entity).setAnimation("teleport5");
					}
					MidnightlurkerMod.queueServerWork(13, () -> {
						if (!entity.getWorld().isClient())
							entity.discard();
					});
				});
			}

			if (((IEntityDataSaver)entity).getPersistentData().getDouble("SeenDisappear") >= 1) {
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
					if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerUnprovokedEntity) {
						if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 30)) {
							if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate1") < 3 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 30)) {
								((IEntityDataSaver)entity).getPersistentData().putDouble("SoundActivate1", (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate1") + 1));
							}
							if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate1") == 1) {
								MidnightlurkerMod.queueServerWork(2, () -> {
									if (world instanceof World level) {
										if (!level.isClient()) {
											level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
										} else {
											level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
										}
									}
								});
							}
							if (entity instanceof MidnightLurkerUnprovokedEntity) {
								((MidnightLurkerUnprovokedEntity) entity).setAnimation("teleport5");
							}
							MidnightlurkerMod.queueServerWork(13, () -> {
								if (!entity.getWorld().isClient())
									entity.discard();
							});
						}
					}
				}
			}
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleClimbing(world, entity, x, y, z);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("encount", (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") + 1));
			}
		}

		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") == 1) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
					}
				}
			}
		}

		EntityTickActions.handleDamageScaling(world, entity, x, y, z);

		if (((IEntityDataSaver)entity).getPersistentData().getBoolean("Stunned")) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") <= 0) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", 1);
			}
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") > 0 && ((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") < 200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") + 1));
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") >= 200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("StunTimer", 0);
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") >= 98) {
			if (((IEntityDataSaver)entity).getPersistentData().getBoolean("Stunned")) {
				((IEntityDataSaver)entity).getPersistentData().putBoolean("Stunned", false);
			}
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") > 0 && ((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") < 98) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3, 255, false, false));
			if (entity instanceof MidnightLurkerUnprovokedEntity) {
				((MidnightLurkerUnprovokedEntity) entity).setAnimation("stunned5");
			}
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") == 2) {
			if (!world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stunned neutral @a ~ ~ ~ 1 1");
			}
			MidnightlurkerMod.queueServerWork(30, () -> {
				if (!world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
					if (world instanceof ServerWorld level)
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
								"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.7 1");
				}
			});
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StunTimer") == 88) {
			if (!world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
			}
		}
	}
}
