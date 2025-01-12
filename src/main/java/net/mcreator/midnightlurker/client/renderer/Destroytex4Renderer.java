
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;
import net.minecraft.util.Identifier;

public class Destroytex4Renderer extends MobEntityRenderer<Destroytex4Entity, Modeldestroytex<Destroytex4Entity>> {
	public Destroytex4Renderer(EntityRendererFactory.Context context) {
		super(context, new Modeldestroytex(context.getPart(Modeldestroytex.LAYER_LOCATION)), 0f);
	}
	@Override
	public Identifier getTexture(Destroytex4Entity entity) {
		return Identifier.of("midnightlurker:textures/entities/destroytex4.png");
	}
}
