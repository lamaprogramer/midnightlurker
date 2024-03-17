
package net.mcreator.midnightlurker.client.screens;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;


import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.procedures.ShowJump2DStage6Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame30Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame29Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame28Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame27Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame26Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame25Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame24Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame23Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame22Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame21Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;


public class Jumpscare72Stage6Overlay implements HudRenderCallback {
	
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
		if (ShowJump2DStage6Procedure.execute(entity)) {
			if (JumpscarerFrame30Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer1stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame29Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer2stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame28Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer3stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame27Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer4stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame26Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer5stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame25Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer6stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame24Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer7stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame23Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer8stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame22Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer9stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame21Procedure.execute(entity)) {
				drawContext.drawTexture(new Identifier("midnightlurker:textures/screens/jumpscarer10stage6.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
