package net.mcreator.midnightlurker.entity.layer;

import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class MidnightLurkerUnprovokedLayer extends GeoRenderLayer<MidnightLurkerUnprovokedEntity> {
	private static final Identifier LAYER = Identifier.of("midnightlurker", "textures/entities/midnightlurkervoidgateemissive.png");

	public MidnightLurkerUnprovokedLayer(GeoRenderer<MidnightLurkerUnprovokedEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(MatrixStack poseStack, MidnightLurkerUnprovokedEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderLayer glowRenderType = RenderLayer.getEyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.DEFAULT_UV, 1);
	}
}
