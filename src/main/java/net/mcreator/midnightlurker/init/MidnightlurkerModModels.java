
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;


import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class MidnightlurkerModModels {
	public static void init() {
		EntityModelLayerRegistry.registerModelLayer(Modeldestroytex.LAYER_LOCATION, Modeldestroytex::createBodyLayer);
	}
}
