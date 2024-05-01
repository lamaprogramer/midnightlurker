package net.mcreator.midnightlurker.entity.model;

import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.data.EntityModelData;

public class MidnightLurkertposeModel extends GeoModel<MidnightLurkertposeEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkertposeEntity entity) {
		return new Identifier("midnightlurker", "animations/tposemidnightlurker.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkertposeEntity entity) {
		return new Identifier("midnightlurker", "geo/tposemidnightlurker.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkertposeEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkertposeEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !MinecraftClient.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
