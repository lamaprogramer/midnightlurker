
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerShadowEyesModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerShadowEyesLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class MidnightLurkerShadowEyesRenderer extends GeoEntityRenderer<MidnightLurkerShadowEyesEntity> {
	public MidnightLurkerShadowEyesRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new MidnightLurkerShadowEyesModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkerShadowEyesLayer(this));
	}

	@Override
	public RenderLayer getRenderType(MidnightLurkerShadowEyesEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, MidnightLurkerShadowEyesEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
