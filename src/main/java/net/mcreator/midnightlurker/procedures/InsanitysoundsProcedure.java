package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InsanitysoundsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanitySounds") < 159) {
			entity.getPersistentData().putDouble("InsanitySounds", (entity.getPersistentData().getDouble("InsanitySounds") + 1));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanitySounds") >= 159) {
			entity.getPersistentData().putDouble("InsanitySounds", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanitySounds") > 0) {
			entity.getPersistentData().putDouble("InsanitySounds", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanityStage") < 7) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanityambience neutral @p");
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanityStage") >= 7) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) : false) && entity.getPersistentData().getDouble("InsanitySounds") == 1
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) > 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:insanitychase neutral @p");
			}
		}
	}
}
