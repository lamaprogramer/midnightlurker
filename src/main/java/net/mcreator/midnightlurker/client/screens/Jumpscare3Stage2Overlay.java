
package net.mcreator.midnightlurker.client.screens;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;


import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.procedures.ShowJump3Stage2Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame17Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame16Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame15Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame14Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame13Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame12Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;


public class Jumpscare3Stage2Overlay implements HudRenderCallback {
	
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
		if (ShowJump3Stage2Procedure.execute(entity)) {
			if (JumpscareFrame15Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird4stage2.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame14Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird3stage2.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame13Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird2stage2.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame12Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird1stage2.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame16Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird5stage2.png"), posX + -513, posY + -211, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame17Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarethird6stage2.png"), posX + -513, posY + -391, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
