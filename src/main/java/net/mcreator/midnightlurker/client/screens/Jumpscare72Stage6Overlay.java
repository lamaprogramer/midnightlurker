
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
import java.util.List;
import java.util.Map;


public class Jumpscare72Stage6Overlay implements HudRenderCallback {
	
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

		Map<List<Integer>, Identifier> frameMap = new HashMap<>();
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_28"), JumpscareFrames.FRAME_MAP.get("FRAME_46")), Identifier.of("midnightlurker:textures/screens/jumpscarer1stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_29"), JumpscareFrames.FRAME_MAP.get("FRAME_45")), Identifier.of("midnightlurker:textures/screens/jumpscarer2stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_30"), JumpscareFrames.FRAME_MAP.get("FRAME_44")), Identifier.of("midnightlurker:textures/screens/jumpscarer3stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_31"), JumpscareFrames.FRAME_MAP.get("FRAME_43")), Identifier.of("midnightlurker:textures/screens/jumpscarer4stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_32"), JumpscareFrames.FRAME_MAP.get("FRAME_42")), Identifier.of("midnightlurker:textures/screens/jumpscarer5stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_33"), JumpscareFrames.FRAME_MAP.get("FRAME_41")), Identifier.of("midnightlurker:textures/screens/jumpscarer6stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_34"), JumpscareFrames.FRAME_MAP.get("FRAME_40")), Identifier.of("midnightlurker:textures/screens/jumpscarer7stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_35"), JumpscareFrames.FRAME_MAP.get("FRAME_39")), Identifier.of("midnightlurker:textures/screens/jumpscarer8stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_36"), JumpscareFrames.FRAME_MAP.get("FRAME_38")), Identifier.of("midnightlurker:textures/screens/jumpscarer9stage6.png"));
		frameMap.put(List.of(JumpscareFrames.FRAME_MAP.get("FRAME_37")), Identifier.of("midnightlurker:textures/screens/jumpscarer10stage6.png"));

		JumpscareHandler.renderJumpscareWithDuplicateFrames(drawContext, (IEntityDataSaver) entity, JumpscareHandler.shouldJumpscare(entity, 6, -1), frameMap, posX + -513, posY + -130);

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
