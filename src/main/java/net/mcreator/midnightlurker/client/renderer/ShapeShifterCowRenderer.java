
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.CowEntityModel;

import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;

public class ShapeShifterCowRenderer extends MobEntityRenderer<ShapeShifterCowEntity, CowEntityModel<ShapeShifterCowEntity>> {
	public ShapeShifterCowRenderer(EntityRendererFactory.Context context) {
		super(context, new CowEntityModel(context.getPart(EntityModelLayers.COW)), 0.7f);
	}

	@Override
	public Identifier getTexture(ShapeShifterCowEntity entity) {
		return Identifier.of("midnightlurker:textures/entities/shapeshiftercow.png");
	}
}
