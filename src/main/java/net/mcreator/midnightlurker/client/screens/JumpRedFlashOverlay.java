
package net.mcreator.midnightlurker.client.screens;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mcreator.midnightlurker.client.screens.animation.AnimationBuilder;
import net.mcreator.midnightlurker.client.screens.animation.FrameScheduler;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;


public class JumpRedFlashOverlay implements HudRenderCallback {
	public static final FrameScheduler frameScheduler = new FrameScheduler(
			new AnimationBuilder()
					.addFrame(29, Identifier.of("midnightlurker:textures/screens/jumpred1.png"))
					.addFrame(28, Identifier.of("midnightlurker:textures/screens/jumpred2.png"))
					.addFrame(27, Identifier.of("midnightlurker:textures/screens/jumpred3.png"))
					.addFrame(26, Identifier.of("midnightlurker:textures/screens/jumpred4.png"))
					.addFrame(25, Identifier.of("midnightlurker:textures/screens/jumpred5.png"))
					.addFrame(24, Identifier.of("midnightlurker:textures/screens/jumpred6.png"))
					.addFrame(23, Identifier.of("midnightlurker:textures/screens/jumpred7.png"))
					.addFrame(22, Identifier.of("midnightlurker:textures/screens/jumpred8.png"))
					.addFrame(21, Identifier.of("midnightlurker:textures/screens/jumpred9.png"))
					.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpred10.png"))
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

		IEntityDataSaver entityData = (IEntityDataSaver) entity;

		if (entityData.getPersistentData().getDouble("JumpscareActive") == 1) {
			frameScheduler.playAnimation(drawContext,
				(int) entityData.getPersistentData().getDouble("JumpscareTimer"),
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
