
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mcreator.midnightlurker.client.renderer.*;

public class MidnightlurkerModEntityRenderers {
	
	public static void init() {
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE, MidnightLurkerAggressiveRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE, MidnightLurkertposeRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING, MidnightLurkerStalkingRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE, MidnightLurkerInvisibleRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.SPOOKYAMBIENCEENTITY, SpookyambienceentityRenderer::new);
		EntityRendererRegistry.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE, MidnightLurkerSeenAngressiveRenderer::new);
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
