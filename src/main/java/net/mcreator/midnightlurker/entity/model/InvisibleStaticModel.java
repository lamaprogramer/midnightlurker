package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;

public class InvisibleStaticModel extends GeoModel<InvisibleStaticEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleStaticEntity entity) {
		return new Identifier("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleStaticEntity entity) {
		return new Identifier("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleStaticEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
