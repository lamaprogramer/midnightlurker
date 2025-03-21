package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;

public class InvisibleFootstepsModel extends GeoModel<InvisibleFootstepsEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
