
package net.mcreator.midnightlurker.client.screens;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.procedures.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class InsanityBarOverlay implements ScreenEvents.AfterRender {
	public void afterRender(Screen screen, DrawContext drawContext, int mouseX, int mouseY, float tickDelta) {
		if (screen instanceof InventoryScreen) {
			int w = screen.width;
			int h = screen.height;
			int posX = w / 2;
			int posY = h / 2;
			PlayerEntity entity = MinecraftClient.getInstance().player;
			World world = entity.getWorld();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexProgram);
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);

			if (InsanityBarHasInsanityPotionProcedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystagecharge.png"), 0, 0, 0, 0, w, h, w, h);
			}else if (InsanityBarStage0Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage0.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage1Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage1.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage2Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage2.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage3Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage3.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage4Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage4.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage5Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage5.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage6Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage6.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (InsanityBarStage7Procedure.execute(world, x, y, z, entity)) {
				drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystage7.png"), 0, 0, 0, 0, w, h, w, h);
			}
			
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
