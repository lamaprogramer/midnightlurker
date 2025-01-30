
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


public class LurkStaticOverlay implements HudRenderCallback {

	private static final FrameScheduler staticOverlay = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/static2.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/static1.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/static2.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/static1.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/static2.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/static1.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/static2.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/static1.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/static2.png"))
			.build()
	);

	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		PlayerEntity entity = MinecraftClient.getInstance().player;
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;

		if (entity != null && entity.hasStatusEffect(MidnightlurkerModMobEffects.STATIC_EFFECT)) {
			int w = drawContext.getScaledWindowWidth();
			int h = drawContext.getScaledWindowHeight();

			int posX = w / 2;
			int posY = h / 2;

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexProgram);
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);

			staticOverlay.playAnimation(drawContext,
					(int) dataSaver.getPersistentData().getDouble("StaticRender"),
					w, h,
					0, 0
			);

			drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/lurkeyes.png"), posX + -139, posY + -58, 0, 0, 278, 98, 278, 98);

			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
