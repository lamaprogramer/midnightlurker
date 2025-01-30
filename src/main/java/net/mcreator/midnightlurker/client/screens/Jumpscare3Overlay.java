
package net.mcreator.midnightlurker.client.screens;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mcreator.midnightlurker.client.screens.animation.AnimationBuilder;
import net.mcreator.midnightlurker.client.screens.animation.FrameScheduler;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;


public class Jumpscare3Overlay implements HudRenderCallback {
	private static final FrameScheduler jumpscareStage0 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage1 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage1.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage1.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage1.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage1.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage1.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage1.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage2 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage2.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage2.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage2.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage2.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage2.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage2.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage3 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage3.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage3.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage3.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage3.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage3.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage3.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage4 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage4.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage4.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage4.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage4.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage4.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage4.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage5 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage5.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage5.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage5.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage5.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage5.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage5.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage6 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarethird6stage6.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarethird5stage6.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarethird4stage6.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarethird3stage6.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarethird2stage6.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarethird1stage6.png"))
			.build()
	);

	private static final FrameScheduler[] JUMPSCARES = {jumpscareStage0, jumpscareStage1, jumpscareStage2,
			jumpscareStage3, jumpscareStage4, jumpscareStage5, jumpscareStage6};
	
	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		PlayerEntity entity = MinecraftClient.getInstance().player;
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;

		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1) {
			int insanity = (int) dataSaver.getPersistentData().getDouble("InsanityStage");
			int random = (int) dataSaver.getPersistentData().getDouble("JumpscareRandom");

			if (!(random == 2 && insanity < JUMPSCARES.length && insanity >= 0)) {
				return;
			}

			int w = drawContext.getScaledWindowWidth();
			int h = drawContext.getScaledWindowHeight();
			int posX = w / 2;
			int posY = h / 2;

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexProgram);
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);

			JUMPSCARES[insanity].playAnimation(drawContext,
					(int) dataSaver.getPersistentData().getDouble("JumpscareTimer"),
					1023, 528,
					posX - 513, posY - 130
			);

			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
