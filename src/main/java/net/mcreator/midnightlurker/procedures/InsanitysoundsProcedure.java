package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class InsanitysoundsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) && entity.getPersistentData().getDouble("InsanitySounds") < 159) {
			entity.getPersistentData().putDouble("InsanitySounds", (entity.getPersistentData().getDouble("InsanitySounds") + 1));
		} else if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) && entity.getPersistentData().getDouble("InsanitySounds") >= 159) {
			entity.getPersistentData().putDouble("InsanitySounds", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) && entity.getPersistentData().getDouble("InsanitySounds") > 0) {
			entity.getPersistentData().putDouble("InsanitySounds", 0);
		}
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())
				&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) && entity.getPersistentData().getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanityambience neutral @p");
			}
		} else if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())
				&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage >= 7) {
			if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) && entity.getPersistentData().getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanitychase neutral @p");
			}
		}
	}
}
