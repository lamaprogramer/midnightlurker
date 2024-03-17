
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerFakerAggroModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerFakerAggroLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class MidnightLurkerFakerAggroRenderer extends GeoEntityRenderer<MidnightLurkerFakerAggroEntity> {
	public MidnightLurkerFakerAggroRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new MidnightLurkerFakerAggroModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkerFakerAggroLayer(this));
	}

	@Override
	public RenderLayer getRenderType(MidnightLurkerFakerAggroEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, MidnightLurkerFakerAggroEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
