
package net.mcreator.midnightlurker.client.screens;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.JumpscareFrames;
import net.mcreator.midnightlurker.util.JumpscareHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;


public class Jumpscare2Stage4Overlay implements HudRenderCallback {
	
	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		int w = drawContext.getScaledWindowWidth();
		int h = drawContext.getScaledWindowHeight();

		int posX = w / 2;
		int posY = h / 2;
		World world = null;
		PlayerEntity entity = MinecraftClient.getInstance().player;
		if (entity != null) {
			world = entity.getWorld();
		}
		
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		Map<Integer, Identifier> frameMap = new HashMap<>();
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_17"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_16"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_15"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_14"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_13"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_12"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_11"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_10"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_9"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_8"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_7"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_6"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_5"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_4"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_3"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage4.png"));
		frameMap.put(JumpscareFrames.FRAME_MAP.get("FRAME_2"), Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage4.png"));

		JumpscareHandler.renderJumpscare(drawContext, (IEntityDataSaver) entity, JumpscareHandler.shouldJumpscare(entity, 4, 1), frameMap, posX + -513, posY + -130);

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
