
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerBackturnedModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerBackturnedLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class MidnightLurkerBackturnedRenderer extends GeoEntityRenderer<MidnightLurkerBackturnedEntity> {
	public MidnightLurkerBackturnedRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new MidnightLurkerBackturnedModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkerBackturnedLayer(this));
	}

	@Override
	public RenderLayer getRenderType(MidnightLurkerBackturnedEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, MidnightLurkerBackturnedEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
