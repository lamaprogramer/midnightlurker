
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


public class Jumpscare2Overlay implements HudRenderCallback {

	public static final FrameScheduler jumpscareStage0 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage1 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage1.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage1.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage1.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage1.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage1.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage1.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage1.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage1.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage1.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage1.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage1.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage1.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage1.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage1.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage1.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage1.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage2 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage2.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage2.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage2.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage2.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage2.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage2.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage2.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage2.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage2.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage2.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage2.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage2.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage2.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage2.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage2.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage2.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage3 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage3.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage3.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage3.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage3.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage3.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage3.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage3.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage3.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage3.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage3.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage3.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage3.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage3.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage3.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage3.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage3.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage4 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage4.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage4.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage4.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage4.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage4.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage4.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage4.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage4.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage4.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage4.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage4.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage4.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage4.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage4.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage4.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage4.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage5 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage5.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage5.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage5.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage5.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage5.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage5.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage5.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage5.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage5.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage5.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage5.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage5.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage5.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage5.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage5.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage5.png"))
			.build()
	);

	public static final FrameScheduler jumpscareStage6 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscaresecond16stage6.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscaresecond15stage6.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscaresecond14stage6.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscaresecond13stage6.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscaresecond12stage6.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscaresecond11stage6.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscaresecond10stage6.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscaresecond9stage6.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscaresecond8stage6.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscaresecond7stage6.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscaresecond6stage6.png"))
			.addFrame(41, Identifier.of("midnightlurker:textures/screens/jumpscaresecond5stage6.png"))
			.addFrame(42, Identifier.of("midnightlurker:textures/screens/jumpscaresecond4stage6.png"))
			.addFrame(43, Identifier.of("midnightlurker:textures/screens/jumpscaresecond3stage6.png"))
			.addFrame(44, Identifier.of("midnightlurker:textures/screens/jumpscaresecond2stage6.png"))
			.addFrame(45, Identifier.of("midnightlurker:textures/screens/jumpscaresecond1stage6.png"))
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

			if (!(random == 1 && insanity < JUMPSCARES.length && insanity >= 0)) {
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
