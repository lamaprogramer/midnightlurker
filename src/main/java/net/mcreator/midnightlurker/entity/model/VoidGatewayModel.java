package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.VoidGatewayEntity;

public class VoidGatewayModel extends GeoModel<VoidGatewayEntity> {
	@Override
	public Identifier getAnimationResource(VoidGatewayEntity entity) {
		return new Identifier("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(VoidGatewayEntity entity) {
		return new Identifier("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(VoidGatewayEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
