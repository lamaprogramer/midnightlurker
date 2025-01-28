package net.mcreator.midnightlurker.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FogShape;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
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

		if (entity instanceof PlayerEntity player && player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			red = 62 / 255.0F;
			green = 20 / 255.0F;
			blue = 25 / 255.0F;
		}
	}

    @Inject(method = "applyFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V", shift = At.Shift.BEFORE))
    private static void modifyApplyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci, @Local BackgroundRenderer.FogData fogData) {
        Entity entity = camera.getFocusedEntity();

        if (entity instanceof PlayerEntity player) {
			IEntityDataSaver playerData = (IEntityDataSaver) player;
			
			if (player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
				fogData.fogStart = 1;
				fogData.fogEnd = (float) playerData.getPersistentData().getDouble("InsanityFog");
				fogData.fogShape = FogShape.SPHERE;
	
				if ((player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? player.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& playerData.getPersistentData().getDouble("InsanityFog") >= 201) {
					playerData.getPersistentData().putDouble("InsanityFog", 200);
				}
				
				if ((player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? player.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& playerData.getPersistentData().getDouble("InsanityFog") > 14) {
					playerData.getPersistentData().putDouble("InsanityFog", (playerData.getPersistentData().getDouble("InsanityFog") - 1));
				}
				
				if ((player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? player.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 52
						&& playerData.getPersistentData().getDouble("InsanityFog") < 200) {
					playerData.getPersistentData().putDouble("InsanityFog", (playerData.getPersistentData().getDouble("InsanityFog") + 1));
				}

				if (playerData.getPersistentData().getDouble("InsanityFog") < 1) {
					playerData.getPersistentData().putDouble("InsanityFog", 201);
				}
			} else {
				playerData.getPersistentData().putDouble("InsanityFog", 201);
			}
		}
    }
}
