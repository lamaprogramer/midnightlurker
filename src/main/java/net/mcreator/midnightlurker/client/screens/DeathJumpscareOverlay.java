
package net.mcreator.midnightlurker.client.screens;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.procedures.DeathJumpBackingProcProcedure;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;


public class DeathJumpscareOverlay implements ScreenEvents.AfterRender {
	public void afterRender(Screen screen, DrawContext drawContext, int mouseX, int mouseY, float tickDelta) {
		if (screen instanceof DeathScreen) {
			int w = screen.width;
			int h = screen.height;
			int posX = w / 2;
			int posY = h / 2;
			PlayerEntity entity = MinecraftClient.getInstance().player;

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexProgram);
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);

			if (DeathJumpBackingProcProcedure.execute(entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/ideaing1black.png"), 0, 0, 0, 0, w, h, w, h);
				if (DeathJumpBackingProcProcedure.execute(entity)) {
					drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/ideaing1.png"), posX + -90, posY + -85, 0, 0, 162, 171, 162, 171);
				}
			}

			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
