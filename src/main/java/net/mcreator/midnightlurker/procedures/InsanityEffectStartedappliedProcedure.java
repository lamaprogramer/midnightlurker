package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import org.jetbrains.annotations.Nullable;


//public class InsanityEffectStartedappliedProcedure {
//
//	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
//		try {
//			ClientWorld clientLevel = MinecraftClient.getInstance().level;
//			Entity entity = event.getCamera().getEntity();
//			execute(null, entity, event);
//		} catch (Exception e) {
//		}
//	}
//
//	public static void execute(Entity entity, ViewportEvent viewport) {
//		execute(null, entity, viewport);
//	}
//
//	private static void execute(@Nullable Event event, Entity entity, ViewportEvent viewport) {
//		if (entity == null || viewport == null)
//			return;
//		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
//			if (entity instanceof PlayerEntity) {
//				if (viewport instanceof ViewportEvent.ComputeFogColor _computeFogColor) {
//					_computeFogColor.setRed(62 / 255.0F);
//					_computeFogColor.setGreen(20 / 255.0F);
//					_computeFogColor.setBlue(25 / 255.0F);
//				}
//			}
//		}
//	}
//}
