
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerShadowEyesModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerShadowEyesLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerShadowEyesRenderer extends GeoEntityRenderer<MidnightLurkerShadowEyesEntity> {
	public MidnightLurkerShadowEyesRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerShadowEyesModel());
		this.shadowRadius = 0.7f;
		this.addLayer(new MidnightLurkerShadowEyesLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerShadowEyesEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
