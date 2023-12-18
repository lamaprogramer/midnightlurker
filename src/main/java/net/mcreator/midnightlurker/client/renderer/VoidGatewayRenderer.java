
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.VoidGatewayModel;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class VoidGatewayRenderer extends GeoEntityRenderer<VoidGatewayEntity> {
	public VoidGatewayRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new VoidGatewayModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(VoidGatewayEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
