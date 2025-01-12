
package net.mcreator.midnightlurker.client.renderer;

import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerRunawayLayer;
import net.mcreator.midnightlurker.entity.model.MidnightLurkerRunawayModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MidnightLurkerRunawayRenderer extends GeoEntityRenderer<MidnightLurkerRunawayEntity> {
	public MidnightLurkerRunawayRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new MidnightLurkerRunawayModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkerRunawayLayer(this));
	}

	@Override
	public RenderLayer getRenderType(MidnightLurkerRunawayEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, MidnightLurkerRunawayEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
	}
}
