
package net.mcreator.midnightlurker.client.renderer;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.model.VoidHandsModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoidHandsRenderer extends GeoEntityRenderer<VoidHandsEntity> {
	public VoidHandsRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new VoidHandsModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderLayer getRenderType(VoidHandsEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, VoidHandsEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
	}
}
