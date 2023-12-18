
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightlurkerNEModel;
import net.mcreator.midnightlurker.entity.layer.MidnightlurkerNELayer;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightlurkerNERenderer extends GeoEntityRenderer<MidnightlurkerNEEntity> {
	public MidnightlurkerNERenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightlurkerNEModel());
		this.shadowRadius = 0.7f;
		this.addLayer(new MidnightlurkerNELayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightlurkerNEEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
