
package net.mcreator.midnightlurker.client.renderer;

import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;
import net.mcreator.midnightlurker.entity.model.InvisibleCaveSoundsModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class InvisibleCaveSoundsRenderer extends GeoEntityRenderer<InvisibleCaveSoundsEntity> {
	public InvisibleCaveSoundsRenderer(EntityRendererFactory.Context renderManager) {
		super(renderManager, new InvisibleCaveSoundsModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderLayer getRenderType(InvisibleCaveSoundsEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(MatrixStack poseStack, InvisibleCaveSoundsEntity animatable, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
	}
}
