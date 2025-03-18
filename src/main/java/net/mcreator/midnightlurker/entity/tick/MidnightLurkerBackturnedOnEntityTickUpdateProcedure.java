package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.AnimatableEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.animations.Animations;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerBackturnedOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		
		if (entityData.getPersistentData().getDouble("PlayerActivation") <= 0 
				&& !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 60)) {
			entityData.getPersistentData().putDouble("PlayerActivation", (entityData.getPersistentData().getDouble("PlayerActivation") + 1));
		}

		if (entityData.getPersistentData().getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof AnimatableEntity animatableEntity && !entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
				animatableEntity.setAnimation("snapstare");
				EntityTickActions.handleEffect(entity, MidnightlurkerModMobEffects.INSANITY, 80, 0, false, false);
            }
		}

		if (entityData.getPersistentData().getDouble("PlayerActivation") >= 1) {
			if (entityData.getPersistentData().getDouble("InsanePotionTimer") < 2) {
				entityData.getPersistentData().putDouble("InsanePotionTimer", (entityData.getPersistentData().getDouble("InsanePotionTimer") + 1));
			}
		}

		if (entityData.getPersistentData().getDouble("SlownessEffect") < 1 && entityData.getPersistentData().getDouble("PlayerActivation") >= 1
				&& (entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? entity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 1
				&& entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			entityData.getPersistentData().putDouble("SlownessEffect", (entityData.getPersistentData().getDouble("SlownessEffect") + 1));
		}

		if (entityData.getPersistentData().getDouble("SlownessEffect") <= 0
				&& !entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)
				&& entityData.getPersistentData().getDouble("PlayerActivation") <= 0) {
			entityData.getPersistentData().putDouble("SlownessEffect", 0);
		}

		if (entityData.getPersistentData().getDouble("SlownessEffect") <= 0) {
			EntityTickActions.handleEffect(entity, StatusEffects.SLOWNESS, 10, 255, false, false);
		}

		EntityTickActions.handleEffect(entity, StatusEffects.DOLPHINS_GRACE, 60, 0, false, false);
		EntityTickActions.handleAutoDismount(entity);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 30)) {
			SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

			if (entity instanceof AnimatableEntity animatableEntity) {
				animatableEntity.setAnimation(Animations.TELEPORT_1);
			}

			if (!entity.getWorld().isClient())
				entity.discard();
		}

		if (entityData.getPersistentData().getDouble("SlownessEffect") <= 0 && entity.hasStatusEffect(StatusEffects.SLOWNESS)) {
			entity.setSneaking(true);
		} else if (entityData.getPersistentData().getDouble("SlownessEffect") >= 1 && entity.hasStatusEffect(StatusEffects.SLOWNESS)) {
			entity.setSneaking(false);
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		handleDiscardOnLook(world, entity, entityData, x, y, z);
		EntityTickActions.handleClimbing(world, entity, x, y, z);
		handleCaveSounds(world, entity, entityData, x, y ,z);
		EntityTickActions.handleEncounter(world, entity, entityData, x, y, z);
	}
	
	public static void handleDiscardOnLook(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 23)) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 80) instanceof MidnightLurkerBackturnedEntity) {
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 30)) {
					if (entityData.getPersistentData().getDouble("SoundActivate") < 3 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 30)) {
						entityData.getPersistentData().putDouble("SoundActivate", (entityData.getPersistentData().getDouble("SoundActivate") + 1));
					}
					if (entityData.getPersistentData().getDouble("SoundActivate") == 1) {
						SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
					}
					if (entity instanceof MidnightLurkerBackturnedEntity) {
						((MidnightLurkerBackturnedEntity) entity).setAnimation(Animations.TELEPORT_1);
					}
					MidnightlurkerMod.queueServerWork(13, () -> {
						if (!entity.getWorld().isClient()) entity.discard();
					});
				}
			}
		}
	}

	public static void handleCaveSounds(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 80)) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (entityData.getPersistentData().getDouble("CaveSoundLurk") < 300) {
					entityData.getPersistentData().putDouble("CaveSoundLurk", (entityData.getPersistentData().getDouble("CaveSoundLurk") + 1));
				}

				if (entityData.getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld level) {
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.7");
					}
				}
			}
		}
	}
}
