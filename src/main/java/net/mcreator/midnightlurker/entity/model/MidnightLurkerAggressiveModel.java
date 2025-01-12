package net.mcreator.midnightlurker.entity.model;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.data.EntityModelData;

public class MidnightLurkerAggressiveModel extends GeoModel<MidnightLurkerAggressiveEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerAggressiveEntity entity) {
		return Identifier.of("midnightlurker", "animations/midnightlurkerrunning.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerAggressiveEntity entity) {
		return Identifier.of("midnightlurker", "geo/midnightlurkerrunning.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerAggressiveEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerAggressiveEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !MinecraftClient.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
