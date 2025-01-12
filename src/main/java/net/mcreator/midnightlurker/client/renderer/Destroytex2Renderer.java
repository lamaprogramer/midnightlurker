
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;
import net.minecraft.util.Identifier;

public class Destroytex2Renderer extends MobEntityRenderer<Destroytex2Entity, Modeldestroytex<Destroytex2Entity>> {
	public Destroytex2Renderer(EntityRendererFactory.Context context) {
		super(context, new Modeldestroytex<>(context.getPart(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public Identifier getTexture(Destroytex2Entity entity) {
		return Identifier.of("midnightlurker:textures/entities/destroytex2.png");
	}
}
