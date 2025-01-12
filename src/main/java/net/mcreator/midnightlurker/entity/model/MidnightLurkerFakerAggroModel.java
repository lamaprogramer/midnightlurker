package net.mcreator.midnightlurker.entity.model;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.data.EntityModelData;

public class MidnightLurkerFakerAggroModel extends GeoModel<MidnightLurkerFakerAggroEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerFakerAggroEntity entity) {
		return Identifier.of("midnightlurker", "animations/midnightlurkerfaker.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerFakerAggroEntity entity) {
		return Identifier.of("midnightlurker", "geo/midnightlurkerfaker.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerFakerAggroEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerFakerAggroEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !MinecraftClient.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
