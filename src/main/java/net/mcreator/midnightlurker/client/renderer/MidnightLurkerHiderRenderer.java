
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerHiderModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerHiderLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerHiderRenderer extends GeoEntityRenderer<MidnightLurkerHiderEntity> {
	public MidnightLurkerHiderRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerHiderModel());
		this.shadowRadius = 0f;
		this.addLayer(new MidnightLurkerHiderLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerHiderEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
