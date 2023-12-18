
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerInvisibleModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerInvisibleLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerInvisibleRenderer extends GeoEntityRenderer<MidnightLurkerInvisibleEntity> {
	public MidnightLurkerInvisibleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerInvisibleModel());
		this.shadowRadius = 0f;
		this.addLayer(new MidnightLurkerInvisibleLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerInvisibleEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
