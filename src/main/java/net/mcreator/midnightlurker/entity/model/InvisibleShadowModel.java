package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;

public class InvisibleShadowModel extends GeoModel<InvisibleShadowEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleShadowEntity entity) {
		return new Identifier("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleShadowEntity entity) {
		return new Identifier("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleShadowEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
