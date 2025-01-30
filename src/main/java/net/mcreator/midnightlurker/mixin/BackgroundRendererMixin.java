package net.mcreator.midnightlurker.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
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

	@ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V"))
	private static void modifyFogColors(Args args, Camera camera, float partialTicks, ClientWorld level, int renderDistanceChunks, float bossColorModifier) {
		Entity entity = camera.getFocusedEntity();

		if (entity instanceof PlayerEntity player && player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			IEntityDataSaver playerData = (IEntityDataSaver) player;
			double fogFade = playerData.getPersistentData().getDouble("InsanityFog");
			float step = Math.clamp((float)fogFade / 40f, 0f, 1f);

			float r = MathHelper.lerp(step, red, 62 / 255.0F);
			float g = MathHelper.lerp(step, green, 20 / 255.0F);
			float b = MathHelper.lerp(step, blue, 25 / 255.0F);

			red = r;
			green = g;
			blue = b;

			args.set(0, r);
			args.set(1, g);
			args.set(2, b);
		}
	}

    @Inject(method = "applyFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V", shift = At.Shift.BEFORE))
    private static void modifyApplyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci, @Local BackgroundRenderer.FogData fogData) {
        Entity entity = camera.getFocusedEntity();

        if (entity instanceof PlayerEntity player) {
			IEntityDataSaver playerData = (IEntityDataSaver) player;

			if (player.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
				double fogFade = playerData.getPersistentData().getDouble("InsanityFog");
				float step = Math.clamp((float)fogFade / 40f, 0f, 1f);

				fogData.fogStart = MathHelper.lerp(step, fogData.fogStart, 1);
				fogData.fogEnd = MathHelper.lerp(step, fogData.fogEnd, 14);
			}
		}
    }
}
