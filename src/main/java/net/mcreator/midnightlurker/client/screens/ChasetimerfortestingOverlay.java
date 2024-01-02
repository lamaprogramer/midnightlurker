
package net.mcreator.midnightlurker.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.VoidrandomnumberthingProcedure;
import net.mcreator.midnightlurker.procedures.InsanitytimerdisplayProcedure;
import net.mcreator.midnightlurker.procedures.InsanitystagedisplayProcedure;
import net.mcreator.midnightlurker.procedures.HealthboostnumberProcedure;
import net.mcreator.midnightlurker.procedures.CloseTimerdisplayProcedure;
import net.mcreator.midnightlurker.procedures.ChasetimerthingProcedure;
import net.mcreator.midnightlurker.procedures.ChasetimerfortestingDisplayOverlayIngameProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ChasetimerfortestingOverlay {
	@SubscribeEvent(priority = EventPriority.LOW)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (ChasetimerfortestingDisplayOverlayIngameProcedure.execute(world)) {
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					ChasetimerthingProcedure.execute(world), posX + -207, posY + -103, -6750157);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					VoidrandomnumberthingProcedure.execute(world), posX + -207, posY + -76, -3355444);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					InsanitytimerdisplayProcedure.execute(entity), posX + -207, posY + -49, -39322);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					InsanitystagedisplayProcedure.execute(entity), posX + -207, posY + -22, -39271);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_chase_timer"), posX + -207, posY + -112, -6750157);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_void_gateway_random_number"), posX + -207, posY + -85, -3355444);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_timer"), posX + -207, posY + -58, -39322);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_stage"), posX + -207, posY + -31, -39271);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_healthboost"), posX + -207, posY + -4, -13395712);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					HealthboostnumberProcedure.execute(world), posX + -207, posY + 5, -13395712);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.midnightlurker.chasetimerfortesting.label_closespawntimer"), posX + -207, posY + 23, -16724788);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					CloseTimerdisplayProcedure.execute(entity), posX + -207, posY + 32, -16724788);
		}
	}
}
