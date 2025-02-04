package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.WorldAccess;


public class LurkerfaceparticleprocedureProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		CoreConfig config = MidnightlurkerMod.CONFIG;

		if (config.shouldDoInsanityProgressEffect()) {
			if (entity instanceof PlayerEntity entity1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") <= 200
					&& (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 1
							|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 2
							|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 3
							|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 4
							|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 5
							|| ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6)
					&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
					&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
				if (!entity1.getWorld().isClient()) {
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
				}
			}
		}

		if (config.getInsanityCountdownTime() == 1) {
			if (entity instanceof PlayerEntity entity1 && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 4800
					&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
					&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
					&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
				if (!entity1.getWorld().isClient())
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
			}
		}

		if (config.getInsanityCountdownTime() == 2) {
			if (entity instanceof PlayerEntity entity1 && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 10800
					&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
					&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
					&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
				if (!entity1.getWorld().isClient())
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
			}
		}

		if (config.getInsanityCountdownTime() == 3) {
			if (entity instanceof PlayerEntity entity1 && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 22800
					&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
					&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
					&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
				if (!entity1.getWorld().isClient())
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
			}
		}

		if (config.getInsanityCountdownTime() == 4) {
			if (entity instanceof PlayerEntity entity1 && Math.random() > 0.5 && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") > 34800
					&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6
					&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
					&& dataSaver.getPersistentData().getDouble("InsanityAktive") == 1) {
				if (!entity1.getWorld().isClient())
					entity1.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
			}
		}
	}
}
