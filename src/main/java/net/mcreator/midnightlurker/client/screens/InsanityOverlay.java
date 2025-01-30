
package net.mcreator.midnightlurker.client.screens;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mcreator.midnightlurker.client.screens.animation.AnimationBuilder;
import net.mcreator.midnightlurker.client.screens.animation.FrameScheduler;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;


public class InsanityOverlay implements HudRenderCallback {
	public static final FrameScheduler frameScheduler = new FrameScheduler(
			new AnimationBuilder()
					.addFrame(1, Identifier.of("midnightlurker:textures/screens/insanityvignette21.png"))
					.addFrame(2, Identifier.of("midnightlurker:textures/screens/insanityvignette22.png"))
					.addFrame(3, Identifier.of("midnightlurker:textures/screens/insanityvignette23.png"))
					.addFrame(4, Identifier.of("midnightlurker:textures/screens/insanityvignette24.png"))
					.addFrame(5, Identifier.of("midnightlurker:textures/screens/insanityvignette25.png"))
					.addFrame(6, Identifier.of("midnightlurker:textures/screens/insanityvignette26.png"))
					.addFrame(7, Identifier.of("midnightlurker:textures/screens/insanityvignette27.png"))
					.addFrame(8, Identifier.of("midnightlurker:textures/screens/insanityvignette28.png"))
					.addFrame(9, Identifier.of("midnightlurker:textures/screens/insanityvignette29.png"))
					.addFrame(10, Identifier.of("midnightlurker:textures/screens/insanityvignette2.png"))
					.build()
	);

	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		int w = drawContext.getScaledWindowWidth();
		int h = drawContext.getScaledWindowHeight();

		PlayerEntity entity = MinecraftClient.getInstance().player;
		
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		if (entity != null && entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			frameScheduler.playAnimation(drawContext,
					(int) ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityOverlayTime"),
					w, h,
					0, 0
			);
		}

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
