package net.mcreator.midnightlurker.entity.model;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;

public class MidnightLurkerCreepModel extends GeoModel<MidnightLurkerCreepEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerCreepEntity entity) {
		return new Identifier("midnightlurker", "animations/midnightlurkercreep.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerCreepEntity entity) {
		return new Identifier("midnightlurker", "geo/midnightlurkercreep.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerCreepEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerCreepEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !MinecraftClient.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}