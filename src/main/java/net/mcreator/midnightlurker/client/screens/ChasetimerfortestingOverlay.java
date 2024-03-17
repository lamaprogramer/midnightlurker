
package net.mcreator.midnightlurker.client.screens;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;


import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;

import net.mcreator.midnightlurker.procedures.VoidrandomnumberthingProcedure;
import net.mcreator.midnightlurker.procedures.InsanitytimerdisplayProcedure;
import net.mcreator.midnightlurker.procedures.InsanitystagedisplayProcedure;
import net.mcreator.midnightlurker.procedures.HealthboostnumberProcedure;
import net.mcreator.midnightlurker.procedures.ChasetimerfortestingDisplayOverlayIngameProcedure;


public class ChasetimerfortestingOverlay implements HudRenderCallback {
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
		if (ChasetimerfortestingDisplayOverlayIngameProcedure.execute(world)) {
			drawContext.drawText(MinecraftClient.getInstance().textRenderer,

					VoidrandomnumberthingProcedure.execute(world), posX + -207, posY + -94, -3355444, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer,

					InsanitytimerdisplayProcedure.execute(entity), posX + -207, posY + -67, -39322, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer,

					InsanitystagedisplayProcedure.execute(entity), posX + -207, posY + -40, -39271, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.translatable("gui.midnightlurker.chasetimerfortesting.label_void_gateway_random_number"), posX + -207, posY + -103, -3355444, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_timer"), posX + -207, posY + -76, -39322, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_stage"), posX + -207, posY + -49, -39271, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.translatable("gui.midnightlurker.chasetimerfortesting.label_healthboost"), posX + -207, posY + -22, -13395712, false);
			drawContext.drawText(MinecraftClient.getInstance().textRenderer,

					HealthboostnumberProcedure.execute(world), posX + -207, posY + -13, -13395712, false);
		}
	}
}
