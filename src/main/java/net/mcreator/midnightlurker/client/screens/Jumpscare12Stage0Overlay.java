
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jumpscare12Stage0Overlay implements HudRenderCallback {
	
	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		int w = drawContext.getScaledWindowWidth();
		int h = drawContext.getScaledWindowHeight();

		int posX = w / 2;
		int posY = h / 2;
		PlayerEntity entity = MinecraftClient.getInstance().player;
		
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (dataSaver.getPersistentData().getDouble("JumpscareActive") != 1) {
			return;
		}
		
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		Map<List<Integer>, Identifier> frameMap = new HashMap<>();
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_28"), JumpscareFrames.FRAME_MAP.get("FRAME_46")), Identifier.of("midnightlurker:textures/screens/jumpscarer1stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_29"), JumpscareFrames.FRAME_MAP.get("FRAME_45")), Identifier.of("midnightlurker:textures/screens/jumpscarer2stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_30"), JumpscareFrames.FRAME_MAP.get("FRAME_44")), Identifier.of("midnightlurker:textures/screens/jumpscarer3stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_31"), JumpscareFrames.FRAME_MAP.get("FRAME_43")), Identifier.of("midnightlurker:textures/screens/jumpscarer4stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_32"), JumpscareFrames.FRAME_MAP.get("FRAME_42")), Identifier.of("midnightlurker:textures/screens/jumpscarer5stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_33"), JumpscareFrames.FRAME_MAP.get("FRAME_41")), Identifier.of("midnightlurker:textures/screens/jumpscarer6stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_34"), JumpscareFrames.FRAME_MAP.get("FRAME_40")), Identifier.of("midnightlurker:textures/screens/jumpscarer7stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_35"), JumpscareFrames.FRAME_MAP.get("FRAME_39")), Identifier.of("midnightlurker:textures/screens/jumpscarer8stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_36"), JumpscareFrames.FRAME_MAP.get("FRAME_38")), Identifier.of("midnightlurker:textures/screens/jumpscarer9stage0.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_37")), Identifier.of("midnightlurker:textures/screens/jumpscarer10stage0.png"));

		JumpscareHandler.renderJumpscareWithDuplicateFrames(drawContext, (IEntityDataSaver) entity, JumpscareHandler.shouldJumpscare(entity, 0, -1), frameMap, posX + -513, posY + -130);

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
