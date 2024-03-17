package net.mcreator.midnightlurker.procedures;

//public class InsanityOnEffectActiveTickProcedure {
//
//	public static void renderFog(ViewportEvent.RenderFog event) {
//		try {
//			if (event.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
//				ClientWorld clientLevel = MinecraftClient.getInstance().level;
//				Entity entity = event.getCamera().getEntity();
//				execute(null, entity, event);
//				event.setCanceled(true);
//			}
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
//				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
//					_renderFog.setNearPlaneDistance(1);
//					_renderFog.setFarPlaneDistance((float) ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog"));
//				}
//				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
//					_renderFog.setFogShape(FogShape.SPHERE);
//				}
//				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
//						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") >= 201) {
//					((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 200);
//				}
//				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
//						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") > 14) {
//					((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") - 1));
//				}
//				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 52
//						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") < 200) {
//					if (entity instanceof PlayerEntity) {
//						((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") + 1));
//					}
//				}
//			}
//		}
//		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY))) {
//			if (entity instanceof PlayerEntity) {
//				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 201);
//			}
//		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
//			if (entity instanceof PlayerEntity && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") < 1) {
//				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 201);
//			}
//		}
//	}
//}
