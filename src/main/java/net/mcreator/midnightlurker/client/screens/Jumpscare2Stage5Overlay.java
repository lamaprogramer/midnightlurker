
package net.mcreator.midnightlurker.client.screens;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;


import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.procedures.ShowJump2Stage5Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame9Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame8Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame7Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame6Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame5Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame3Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame2Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame17Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame16Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame15Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame14Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame13Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame12Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame11Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame10Procedure;
import net.mcreator.midnightlurker.procedures.Insanityoverlayevent4Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;


public class Jumpscare2Stage5Overlay implements HudRenderCallback {
	
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
		if (ShowJump2Stage5Procedure.execute(entity)) {
			if (JumpscareFrame15Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond14stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame14Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond13stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame13Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond12stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame12Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond11stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame11Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond10stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame10Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond9stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame9Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond8stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame8Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond7stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame7Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond6stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame6Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond5stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame5Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond4stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (Insanityoverlayevent4Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond3stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame3Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond2stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame2Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond1stage5.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame16Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond15stage5.png"), posX + -513, posY + -328, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame17Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscaresecond16stage5.png"), posX + -513, posY + -148, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
