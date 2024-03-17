
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PigEntityModel;

import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;

public class ShapeshifterPigRenderer extends MobEntityRenderer<ShapeshifterPigEntity, PigEntityModel<ShapeshifterPigEntity>> {
	public ShapeshifterPigRenderer(EntityRendererFactory.Context context) {
		super(context, new PigEntityModel(context.getPart(EntityModelLayers.PIG)), 0.7f);
	}

	@Override
	public Identifier getTexture(ShapeshifterPigEntity entity) {
		return new Identifier("midnightlurker:textures/entities/shapeshifterpig.png");
	}
}
