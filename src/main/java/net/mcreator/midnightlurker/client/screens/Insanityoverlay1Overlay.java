
package net.mcreator.midnightlurker.client.screens;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;


import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.procedures.Insanityoverlayevent1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;


public class Insanityoverlay1Overlay implements HudRenderCallback {
	
	public void onHudRender(DrawContext drawContext, float tickDelta) {
		int w = drawContext.getScaledWindowWidth();
		int h = drawContext.getScaledWindowHeight();
		int posX = w / 2;
		int posY = h / 2;
		World world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		PlayerEntity entity = MinecraftClient.getInstance().player;
		if (entity != null) {
			world = entity.getWorld();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (Insanityoverlayevent1Procedure.execute(entity)) {
			drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/insanityvignette21.png"), 0, 0, 0, 0, w, h, w, h);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
