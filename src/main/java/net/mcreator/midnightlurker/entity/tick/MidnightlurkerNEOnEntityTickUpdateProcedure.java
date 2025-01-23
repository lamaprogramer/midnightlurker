package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MidnightlurkerNEOnEntityTickUpdateProcedure {
	private static final Logger log = LoggerFactory.getLogger(MidnightlurkerNEOnEntityTickUpdateProcedure.class);

	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity; 

		EntityTickActions.handleBreakDoors(world, x, y, z);
		EntityTickActions.handleAutoDismount(entity);
		EntityTickActions.handleClimbing(world, entity, x ,y ,z);
		EntityTickActions.handleBlockBreaking(world, entity, entityData, x ,y ,z);
		EntityTickActions.handleSpeedWhenObstructed(world, entity, x, y, z);
		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleGlassBreaking(world, x, y, z);
		EntityTickActions.handleLurkerScream(world, entity, entityData);
		EntityTickActions.handleLurkerChase(world, entity, entityData, x ,y ,z);
		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
		EntityTickActions.handleDamageScaling(world, entity, x ,y ,z);
		handleStunned(world, entity, entityData, x, y, z);
	}

	public static void handleStunned(WorldAccess world, Entity entity, IEntityDataSaver entityData, double x, double y, double z) {
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
			if (entity instanceof MidnightlurkerNEEntity midnightlurkerNE) {
				System.out.println("Stunned animation");
				midnightlurkerNE.setAnimation("stunned1");
			}
		}

		if (entityData.getPersistentData().getDouble("StunTimer") == 2) {
			if (world instanceof ServerWorld level)
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurker_stunned neutral @a ~ ~ ~ 1 1");
			MidnightlurkerMod.queueServerWork(30, () -> {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 0.7 1");
			});
		}

		if (entityData.getPersistentData().getDouble("StunTimer") == 88) {
			if (world instanceof ServerWorld level)
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurker_stun_over neutral @a ~ ~ ~ 1 1");
		}
	}
}
