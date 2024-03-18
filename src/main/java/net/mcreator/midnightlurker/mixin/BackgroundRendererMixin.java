package net.mcreator.midnightlurker.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FogShape;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

	@Shadow private static float red;

	@Shadow private static float green;

	@Shadow private static float blue;

	@ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V", remap = false))
	private static void modifyFogColors(Args args, Camera camera, float partialTicks, ClientWorld level, int renderDistanceChunks, float bossColorModifier) {
		Entity entity = camera.getFocusedEntity();

		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof PlayerEntity) {
				red = 62 / 255.0F;
				green = 20 / 255.0F;
				blue = 25 / 255.0F;
			}
		}
	}

    @Inject(method = "applyFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V", shift = At.Shift.BEFORE))
    private static void modifyApplyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci, @Local BackgroundRenderer.FogData fogData) {
        Entity entity = camera.getFocusedEntity();

        if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof PlayerEntity) {
				fogData.fogStart = 1;
				fogData.fogEnd = (float) ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog");
				fogData.fogShape = FogShape.SPHERE;

				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") >= 201) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 200);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") > 14) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") - 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 52
						&& ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") < 200) {
					if (entity instanceof PlayerEntity) {
						((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") + 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY))) {
			if (entity instanceof PlayerEntity) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 201);
			}
		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof PlayerEntity && ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityFog") < 1) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityFog", 201);
			}
		}
    }
}
