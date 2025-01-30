
package net.mcreator.midnightlurker.client.screens;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.client.screens.animation.AnimationBuilder;
import net.mcreator.midnightlurker.client.screens.animation.FrameScheduler;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class InsanityBarOverlay implements ScreenEvents.AfterRender {
	public static final FrameScheduler frameScheduler = new FrameScheduler(
			new AnimationBuilder()
					.addFrame(0, Identifier.of("midnightlurker:textures/screens/insanitystage0.png"))
					.addFrame(1, Identifier.of("midnightlurker:textures/screens/insanitystage1.png"))
					.addFrame(2, Identifier.of("midnightlurker:textures/screens/insanitystage2.png"))
					.addFrame(3, Identifier.of("midnightlurker:textures/screens/insanitystage3.png"))
					.addFrame(4, Identifier.of("midnightlurker:textures/screens/insanitystage4.png"))
					.addFrame(5, Identifier.of("midnightlurker:textures/screens/insanitystage5.png"))
					.addFrame(6, Identifier.of("midnightlurker:textures/screens/insanitystage6.png"))
					.addFrame(7, Identifier.of("midnightlurker:textures/screens/insanitystage7.png"))
					.build()
	);

	public void afterRender(Screen screen, DrawContext drawContext, int mouseX, int mouseY, float tickDelta) {
		if (screen instanceof InventoryScreen) {
			int w = screen.width;
			int h = screen.height;

			PlayerEntity entity = MinecraftClient.getInstance().player;

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexProgram);
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);

			if (entity != null && MidnightlurkerMod.CONFIG.shouldHaveInsanityBar()) {
				if (entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
					drawContext.drawTexture(Identifier.of("midnightlurker:textures/screens/insanitystagecharge.png"), 0, 0, 0, 0, w, h, w, h);
				} else {
					frameScheduler.playAnimation(drawContext,
                            (int) ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage"),
							w, h,
							0, 0
					);
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
