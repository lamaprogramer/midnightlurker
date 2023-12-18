
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerUnprovokedModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerUnprovokedLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerUnprovokedRenderer extends GeoEntityRenderer<MidnightLurkerUnprovokedEntity> {
	public MidnightLurkerUnprovokedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerUnprovokedModel());
		this.shadowRadius = 0.7f;
		this.addLayer(new MidnightLurkerUnprovokedLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerUnprovokedEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.95f, 0.95f, 0.95f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
