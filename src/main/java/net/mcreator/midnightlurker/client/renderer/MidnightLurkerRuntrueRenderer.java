
package net.mcreator.midnightlurker.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.model.MidnightLurkerRuntrueModel;
import net.mcreator.midnightlurker.entity.layer.MidnightLurkerRuntrueLayer;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerRuntrueRenderer extends GeoEntityRenderer<MidnightLurkerRuntrueEntity> {
	public MidnightLurkerRuntrueRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MidnightLurkerRuntrueModel());
		this.shadowRadius = 0.7f;
		this.addRenderLayer(new MidnightLurkerRuntrueLayer(this));
	}

	@Override
	public RenderType getRenderType(MidnightLurkerRuntrueEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, MidnightLurkerRuntrueEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}