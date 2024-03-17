
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


import net.mcreator.midnightlurker.client.renderer.VoidHandsRenderer;
import net.mcreator.midnightlurker.client.renderer.VoidGatewayRenderer;
import net.mcreator.midnightlurker.client.renderer.SpookyambienceentityRenderer;
import net.mcreator.midnightlurker.client.renderer.ShapeshifterPigRenderer;
import net.mcreator.midnightlurker.client.renderer.ShapeShifterCowRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightlurkerNERenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightPhantomHeadRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkertposeRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerWatcherRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerUnprovokedRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerStareRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerStalkingRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerShapeshifterRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerShadowRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerShadowEyesRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerSeenAngressiveRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerRuntrueRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerRunawayRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerInvisibleRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerHiderRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerFakerWatcherRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerFakerRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerFakerAggroRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerCreepRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerBackturnedRenderer;
import net.mcreator.midnightlurker.client.renderer.MidnightLurkerAggressiveRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleStaticRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleShadowRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleLurkerFootstepsRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleFootstepsRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleCaveSoundsRenderer;
import net.mcreator.midnightlurker.client.renderer.InvisibleAnimalKillerRenderer;
import net.mcreator.midnightlurker.client.renderer.DestroytexRenderer;
import net.mcreator.midnightlurker.client.renderer.Destroytex4Renderer;
import net.mcreator.midnightlurker.client.renderer.Destroytex3Renderer;
import net.mcreator.midnightlurker.client.renderer.Destroytex2Renderer;

public class MidnightlurkerModEntityRenderers {
	
	public static void init() {
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE, MidnightLurkerAggressiveRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE, MidnightLurkertposeRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING, MidnightLurkerStalkingRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE, MidnightLurkerInvisibleRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.SPOOKYAMBIENCEENTITY, SpookyambienceentityRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE, MidnightLurkerSeenAngressiveRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.DESTROYTEX, DestroytexRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.DESTROYTEX_2, Destroytex2Renderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.DESTROYTEX_3, Destroytex3Renderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.DESTROYTEX_4, Destroytex4Renderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO, MidnightLurkerFakerAggroRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER, MidnightLurkerFakerRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_WATCHER, MidnightLurkerFakerWatcherRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.VOID_GATEWAY, VoidGatewayRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_BACKTURNED, MidnightLurkerBackturnedRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW_EYES, MidnightLurkerShadowEyesRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHADOW, MidnightLurkerShadowRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, MidnightLurkerUnprovokedRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNAWAY, MidnightLurkerRunawayRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNTRUE, MidnightLurkerRuntrueRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER, MidnightLurkerHiderRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER, MidnightLurkerShapeshifterRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_STARE, MidnightLurkerStareRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHTLURKER_NE, MidnightlurkerNERenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_WATCHER, MidnightLurkerWatcherRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.VOID_HANDS, VoidHandsRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_FOOTSTEPS, InvisibleFootstepsRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_SHADOW, InvisibleShadowRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_STATIC, InvisibleStaticRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_LURKER_FOOTSTEPS, InvisibleLurkerFootstepsRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_CAVE_SOUNDS, InvisibleCaveSoundsRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_CREEP, MidnightLurkerCreepRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_PHANTOM_HEAD, MidnightPhantomHeadRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.INVISIBLE_ANIMAL_KILLER, InvisibleAnimalKillerRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.SHAPESHIFTER_PIG, ShapeshifterPigRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.SHAPE_SHIFTER_COW, ShapeShifterCowRenderer::new);
	}
}
