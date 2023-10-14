
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.midnightlurker.client.renderer.MidnightLurkertposeRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerStalkingRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerAggressiveRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MidnightlurkerModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.get(), MidnightLurkerAggressiveRenderer::new);
		event.registerEntityRenderer(MidnightlurkerModEntities.MIDNIGHT_LURKER.get(), MidnightLurkerRenderer::new);
		event.registerEntityRenderer(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE.get(), MidnightLurkertposeRenderer::new);
		event.registerEntityRenderer(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING.get(), MidnightLurkerStalkingRenderer::new);
	}
}
