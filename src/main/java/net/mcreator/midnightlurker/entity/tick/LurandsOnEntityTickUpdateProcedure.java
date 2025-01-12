package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class LurandsOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver)entity;
		handlePlayerActivation(world, entity, entityData, x, y, z);
		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE, x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		handleFaking(world, entity, entityData);
		handleReveal(world, entity, entityData, x, y, z);
		handleWaterBreathing(entity);
		handleOpeningDoors(world, x, y, z);
		EntityTickActions.handleAutoDismount(entity);
	}
	
	public static void handlePlayerActivation(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		double playerActivation = entityData.getPersistentData().getDouble("PlayerActivationGateway");
		double closeTime = entityData.getPersistentData().getDouble("CloseTime");
		
		if (playerActivation <= 0 && (entity instanceof LivingEntity livingEntity ? livingEntity.getHealth() : -1) < 10) {
			entityData.getPersistentData().putDouble("PlayerActivationGateway", playerActivation + 1);
		}

		if (playerActivation >= 1) {
			if (entity instanceof VoidHandsEntity voidHands) {
				voidHands.setAnimation("animation.lurands.disappear");
			}
		}

		if (closeTime >= 9) {
			if (!entity.getWorld().isClient()) entity.discard();
		}

		if (playerActivation >= 1 && closeTime < 9) {
			entityData.getPersistentData().putDouble("CloseTime", (closeTime + 1));
		}

		if (closeTime == 4) {
			SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
		}

		if (playerActivation >= 1 && closeTime == 6) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom = MathHelper.nextDouble(Random.create(), 1, 10);
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}

		if (playerActivation >= 1 && closeTime == 8) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
				IEntityDataSaver playerEntityData = ((IEntityDataSaver)EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
				if (playerEntityData.getPersistentData().getDouble("encounternumber") < 6) {
					double _setval = playerEntityData.getPersistentData().getDouble("encounternumber") + 1;
					playerEntityData.getPersistentData().putDouble("encounternumber", _setval);
				}
			}

			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 100)) {
				if (Math.random() > 0.7) {
					IEntityDataSaver playerEntityData = ((IEntityDataSaver)EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 100, 100, 100));
					if (playerEntityData.getPersistentData().getDouble("JumpscareActive") < 1) {
						playerEntityData.getPersistentData().putDouble("JumpscareActive", 1);
					}
				}
			}
		}
	}
	
	public static void handleFaking(WorldAccess world, Entity entity, IEntityDataSaver entityData) {
		if (entityData.getPersistentData().getDouble("Faking") == 0) {
			entity.setSneaking(true);
		} else if (entityData.getPersistentData().getDouble("Faking") == 1) {
			entity.setSneaking(false);
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10) && entityData.getPersistentData().getDouble("Faking") == 0) {
			entityData.getPersistentData().putDouble("Faking", 1);
		}
	}
	
	public static void handleReveal(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			if (entityData.getPersistentData().getDouble("Reveal") < 3) {
				entityData.getPersistentData().putDouble("Reveal", (entityData.getPersistentData().getDouble("Reveal") + 1));
			}
		}

		handleAggroSounds(world, entity, entityData, x, y, z);

		if (entityData.getPersistentData().getDouble("Reveal") == 1) {
			if (entity instanceof VoidHandsEntity voidHands) {
				voidHands.setAnimation("animation.lurands.reveal");
			}
			if (world instanceof ServerWorld level) {
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:voidhands_shriek hostile @a ~ ~ ~ 1 1");
			}
		}
	}
	
	public static void handleAggroSounds(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 65)) {
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 65, 65, 65)) {
				if (entityData.getPersistentData().getDouble("AggroSounds") < 50) {
					entityData.getPersistentData().putDouble("AggroSounds", (entityData.getPersistentData().getDouble("AggroSounds") + 1));
				}
			}
		}

		if (entityData.getPersistentData().getDouble("AggroSounds") >= 50) {
			((IEntityDataSaver) entity).getPersistentData().putDouble("AggroSounds", 0);
			if (world instanceof ServerWorld level) {
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:voidhands_aggro hostile @a ~ ~ ~ 1 1");
			}
		}
	}
	
	public static void handleWaterBreathing(Entity entity) {
		if (entity instanceof LivingEntity livingEntity && !livingEntity.getWorld().isClient()) {
			livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 60, 255, false, false));
		}
	}

	public static void handleOpeningDoors(WorldAccess world, double x, double y, double z) {
		for (Direction direction : new Direction[]{Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH}) {
			BlockPos doorStatePos = BlockPos.ofFloored(x, y, z).offset(direction, 1);
			BlockState doorState = world.getBlockState(doorStatePos);
			
			if (doorState.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("midnightlurker:lurkerdoors")))) {
				if (doorState.getBlock().getStateManager().getProperty("open") instanceof BooleanProperty openProperty && doorState.get(openProperty)) {
					world.setBlockState(doorStatePos, doorState.with(openProperty, true), 3);
					
					if (world instanceof ServerWorld level) {
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z).offset(direction, 1), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
					}
				}
			}
		}
	}
}
