
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.SpookyambienceentityModel;
import net.mcreator.midnightlurker.entity.SpookyambienceentityEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpookyambienceentityRenderer extends GeoEntityRenderer<SpookyambienceentityEntity> {
	public SpookyambienceentityRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SpookyambienceentityModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(SpookyambienceentityEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
