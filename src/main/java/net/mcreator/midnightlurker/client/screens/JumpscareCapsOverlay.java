
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


public class JumpscareCapsOverlay implements HudRenderCallback {
	private static final FrameScheduler jumpscareStage0 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage0.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage0.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage0.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage0.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage0.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage0.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage0.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage0.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage0.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage0.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage0.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage0.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage0.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage0.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage0.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage0.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage0.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage0.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage0.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage1 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage1.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage1.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage1.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage1.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage1.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage1.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage1.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage1.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage1.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage1.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage1.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage1.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage1.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage1.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage1.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage1.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage1.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage1.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage1.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage2 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage2.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage2.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage2.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage2.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage2.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage2.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage2.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage2.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage2.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage2.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage2.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage2.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage2.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage2.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage2.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage2.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage2.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage2.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage2.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage3 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage3.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage3.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage3.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage3.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage3.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage3.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage3.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage3.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage3.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage3.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage3.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage3.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage3.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage3.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage3.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage3.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage3.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage3.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage3.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage4 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage4.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage4.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage4.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage4.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage4.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage4.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage4.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage4.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage4.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage4.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage4.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage4.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage4.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage4.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage4.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage4.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage4.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage4.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage4.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage5 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage5.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage5.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage5.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage5.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage5.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage5.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage5.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage5.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage5.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage5.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage5.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage5.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage5.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage5.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage5.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage5.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage5.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage5.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage5.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage6 = new FrameScheduler(new AnimationBuilder()
			.addFrame(1, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage6.png"))
			.addFrame(2, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage6.png"))
			.addFrame(3, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage6.png"))
			.addFrame(4, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage6.png"))
			.addFrame(5, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage6.png"))
			.addFrame(7, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage6.png"))
			.addFrame(8, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage6.png"))
			.addFrame(9, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage6.png"))
			.addFrame(10, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage6.png"))
			.addFrame(11, Identifier.of("midnightlurker:textures/screens/jumpscarer10stage6.png"))
			.addFrame(12, Identifier.of("midnightlurker:textures/screens/jumpscarer9stage6.png"))
			.addFrame(13, Identifier.of("midnightlurker:textures/screens/jumpscarer8stage6.png"))
			.addFrame(14, Identifier.of("midnightlurker:textures/screens/jumpscarer7stage6.png"))
			.addFrame(15, Identifier.of("midnightlurker:textures/screens/jumpscarer6stage6.png"))
			.addFrame(16, Identifier.of("midnightlurker:textures/screens/jumpscarer5stage6.png"))
			.addFrame(17, Identifier.of("midnightlurker:textures/screens/jumpscarer4stage6.png"))
			.addFrame(18, Identifier.of("midnightlurker:textures/screens/jumpscarer3stage6.png"))
			.addFrame(19, Identifier.of("midnightlurker:textures/screens/jumpscarer2stage6.png"))
			.addFrame(20, Identifier.of("midnightlurker:textures/screens/jumpscarer1stage6.png"))
			.build()
	);

	private static final FrameScheduler[] JUMPSCARES = {jumpscareStage0, jumpscareStage1, jumpscareStage2,
			jumpscareStage3, jumpscareStage4, jumpscareStage5, jumpscareStage6};
	
	public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
		PlayerEntity entity = MinecraftClient.getInstance().player;
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;

		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1) {
			int insanity = (int) dataSaver.getPersistentData().getDouble("InsanityStage");

			if (!(insanity < JUMPSCARES.length && insanity >= 0)) {
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
