package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.animations.Animations;
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
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerUnprovokedOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;

		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entityData.getPersistentData().getDouble("SlownessCountdown") < 2401 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 70)) {
			entityData.getPersistentData().putDouble("SlownessCountdown", (entityData.getPersistentData().getDouble("SlownessCountdown") + 1));
		}

		if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasStatusEffect(StatusEffects.SLOWNESS) && entityData.getPersistentData().getDouble("SlownessCountdown") == 2400) {
            _livEnt7.removeStatusEffect(StatusEffects.SLOWNESS);

		} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasStatusEffect(StatusEffects.SLOWNESS)
				&& !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 20)) {
            _livEnt10.removeStatusEffect(StatusEffects.SLOWNESS);
		}

		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
		EntityTickActions.handleAutoDismount(entity);

		if (entityData.getPersistentData().getDouble("CanDisappear") < 201) {
			entityData.getPersistentData().putDouble("CanDisappear", (entityData.getPersistentData().getDouble("CanDisappear") + 1));
		}

		if (entityData.getPersistentData().getDouble("CanDisappear") >= 200) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 15, 15, 15), e -> true).isEmpty()) {
				SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

				if (entity instanceof MidnightLurkerUnprovokedEntity) {
					((MidnightLurkerUnprovokedEntity) entity).setAnimation(Animations.TELEPORT_1);
				}

				if (!entity.getWorld().isClient())
					entity.discard();
			}

			if (entityData.getPersistentData().getDouble("SeenDisappear") >= 1) {
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
					if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerUnprovokedEntity) {
						SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

						if (entity instanceof MidnightLurkerUnprovokedEntity) {
							((MidnightLurkerUnprovokedEntity) entity).setAnimation(Animations.TELEPORT_1);
						}

						if (!entity.getWorld().isClient())
							entity.discard();
					}
				}
			}
		}


		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleClimbing(world, entity, x, y, z);
		EntityTickActions.handleEncounter(world, entity, entityData, x, y, z);

		EntityTickActions.handleDamageScaling(world, entity, x, y, z);

		if (entityData.getPersistentData().getBoolean("Stunned")) {
			if (entityData.getPersistentData().getDouble("StunTimer") <= 0) {
				entityData.getPersistentData().putDouble("StunTimer", 1);
			}
		}

		if (entityData.getPersistentData().getDouble("StunTimer") > 0 && entityData.getPersistentData().getDouble("StunTimer") < 200) {
			entityData.getPersistentData().putDouble("StunTimer", (entityData.getPersistentData().getDouble("StunTimer") + 1));
		}

		if (entityData.getPersistentData().getDouble("StunTimer") >= 200) {
			entityData.getPersistentData().putDouble("StunTimer", 0);
		}

		if (entityData.getPersistentData().getDouble("StunTimer") >= 98) {
			if (entityData.getPersistentData().getBoolean("Stunned")) {
				entityData.getPersistentData().putBoolean("Stunned", false);
			}
		}

		if (entityData.getPersistentData().getDouble("StunTimer") > 0 && entityData.getPersistentData().getDouble("StunTimer") < 98) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3, 255, false, false));
			if (entity instanceof MidnightLurkerUnprovokedEntity) {
				((MidnightLurkerUnprovokedEntity) entity).setAnimation("stunned5");
			}
		}

		if (entityData.getPersistentData().getDouble("StunTimer") == 2) {
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

		if (entityData.getPersistentData().getDouble("StunTimer") == 88) {
			if (!world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
			}
		}
	}
}
