
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;
import net.minecraft.util.Identifier;

public class DestroytexRenderer extends MobEntityRenderer<DestroytexEntity, Modeldestroytex<DestroytexEntity>> {
	public DestroytexRenderer(EntityRendererFactory.Context context) {
		super(context, new Modeldestroytex(context.getPart(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public Identifier getTexture(DestroytexEntity entity) {
		return new Identifier("midnightlurker:textures/entities/destroytex1.png");
	}
}
