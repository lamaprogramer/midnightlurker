
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


public class Jumpscare1Overlay implements HudRenderCallback {
	private static final FrameScheduler jumpscareStage0 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage1 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage1.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage1.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage1.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage1.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage1.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage1.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage1.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage1.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage1.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage1.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage1.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage2 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage2.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage2.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage2.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage2.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage2.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage2.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage2.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage2.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage2.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage2.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage2.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage3 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage3.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage3.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage3.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage3.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage3.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage3.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage3.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage3.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage3.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage3.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage3.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage4 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage4.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage4.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage4.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage4.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage4.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage4.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage4.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage4.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage4.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage4.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage4.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage5 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage5.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage5.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage5.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage5.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage5.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage5.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage5.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage5.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage5.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage5.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage5.png"))
			.build()
	);

	private static final FrameScheduler jumpscareStage6 = new FrameScheduler(new AnimationBuilder()
			.addFrame(30, Identifier.of("midnightlurker:textures/screens/jumpscarefirst11stage6.png"))
			.addFrame(31, Identifier.of("midnightlurker:textures/screens/jumpscarefirst10stage6.png"))
			.addFrame(32, Identifier.of("midnightlurker:textures/screens/jumpscarefirst9stage6.png"))
			.addFrame(33, Identifier.of("midnightlurker:textures/screens/jumpscarefirst8stage6.png"))
			.addFrame(34, Identifier.of("midnightlurker:textures/screens/jumpscarefirst7stage6.png"))
			.addFrame(35, Identifier.of("midnightlurker:textures/screens/jumpscarefirst6stage6.png"))
			.addFrame(36, Identifier.of("midnightlurker:textures/screens/jumpscarefirst5stage6.png"))
			.addFrame(37, Identifier.of("midnightlurker:textures/screens/jumpscarefirst4stage6.png"))
			.addFrame(38, Identifier.of("midnightlurker:textures/screens/jumpscarefirst3stage6.png"))
			.addFrame(39, Identifier.of("midnightlurker:textures/screens/jumpscarefirst2stage6.png"))
			.addFrame(40, Identifier.of("midnightlurker:textures/screens/jumpscarefirst1stage6.png"))
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

			if (!(random == 0 && insanity < JUMPSCARES.length && insanity >= 0)) {
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
