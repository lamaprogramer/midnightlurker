
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;
import net.minecraft.util.Identifier;

public class Destroytex3Renderer extends MobEntityRenderer<Destroytex3Entity, Modeldestroytex<Destroytex3Entity>> {
	public Destroytex3Renderer(EntityRendererFactory.Context context) {
		super(context, new Modeldestroytex(context.getPart(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public Identifier getTexture(Destroytex3Entity entity) {
		return Identifier.of("midnightlurker:textures/entities/destroytex3.png");
	}
}
