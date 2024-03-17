
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

import net.mcreator.midnightlurker.entity.model.MidnightLurkertposeModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkertposeLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class MidnightLurkertposeRenderer extends GeoEntityRenderer<MidnightLurkertposeEntity> {
	public MidnightLurkertposeRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new MidnightLurkertposeModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkertposeLayer(this));
	}

	@Override
	public RenderLayer getRenderType(MidnightLurkertposeEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, MidnightLurkertposeEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
