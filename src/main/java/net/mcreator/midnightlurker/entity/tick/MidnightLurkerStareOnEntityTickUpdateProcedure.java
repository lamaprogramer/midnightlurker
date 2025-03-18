package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.animations.Animations;
import net.minecraft.command.argument.EntityAnchorArgumentType;
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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerStareOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(StatusEffects.SLOWNESS) && entityData.getPersistentData().getDouble("StareCountdown") == 401) {
            _livEnt0.removeStatusEffect(StatusEffects.SLOWNESS);
		}

		EntityTickActions.handleAutoDismount(entity);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

			if (entity instanceof MidnightLurkerStareEntity) {
				((MidnightLurkerStareEntity) entity).setAnimation(Animations.TELEPORT_1);
			}

			if (!entity.getWorld().isClient())
				entity.discard();
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);

		if (entityData.getPersistentData().getDouble("StareCountdown") >= 401) {
			entityData.getPersistentData().putDouble("Staringat", 0);
		}

		if (entityData.getPersistentData().getDouble("Staringat") == 1) {
			entity.setSneaking(true);
		} else if (entityData.getPersistentData().getDouble("Staringat") == 0) {
			entity.setSneaking(false);
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
			if ((entity.getHorizontalFacing()) == Direction.SOUTH && (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getHorizontalFacing()) == Direction.NORTH
					|| (entity.getHorizontalFacing()) == Direction.NORTH && (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.SOUTH
					|| (entity.getHorizontalFacing()) == Direction.EAST && (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.WEST
					|| (entity.getHorizontalFacing()) == Direction.WEST && (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing()) == Direction.EAST || EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70), entity, 70) instanceof MidnightLurkerStareEntity) {
				if (entityData.getPersistentData().getDouble("StareCountdown") < 401) {
					entityData.getPersistentData().putDouble("StareCountdown", (entityData.getPersistentData().getDouble("StareCountdown") + 1));
				}
				if (entityData.getPersistentData().getDouble("StareCountdown") <= 400) {
					if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
						_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 255, false, false));
					entityData.getPersistentData().putDouble("Staringat", 1);
				} else if (entity instanceof LivingEntity _livEnt61 && _livEnt61.hasStatusEffect(StatusEffects.SLOWNESS) && entityData.getPersistentData().getDouble("StareCountdown") == 401) {
                    _livEnt61.removeStatusEffect(StatusEffects.SLOWNESS);
				}
			} else {
				entityData.getPersistentData().putDouble("Staringat", 0);
			}
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
			entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, new Vec3d((EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getX()), (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getY()), (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).getZ())));
		}

		EntityTickActions.handleClimbing(world, entity, x, y, z);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 80)) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (entityData.getPersistentData().getDouble("CaveSoundLurk") < 300) {
					entityData.getPersistentData().putDouble("CaveSoundLurk", (entityData.getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (entityData.getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld level)
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.7");
				}
			}
		}

		EntityTickActions.handleEncounter(world, entity, entityData, x, y, z);
		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
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
			if (entity instanceof MidnightLurkerStareEntity) {
				((MidnightLurkerStareEntity) entity).setAnimation("stunned");
			}
		}

		if (entityData.getPersistentData().getDouble("StunTimer") == 2) {
			if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stunned neutral @a ~ ~ ~ 1 1");
			}
			MidnightlurkerMod.queueServerWork(30, () -> {
				if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
					if (world instanceof ServerWorld level)
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
								"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.7 1");
				}
			});
		}

		if (entityData.getPersistentData().getDouble("StunTimer") == 88) {
			if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
			}
		}
	}
}
