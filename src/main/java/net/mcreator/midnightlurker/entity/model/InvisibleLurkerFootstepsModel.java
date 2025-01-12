package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;

public class InvisibleLurkerFootstepsModel extends GeoModel<InvisibleLurkerFootstepsEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleLurkerFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleLurkerFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleLurkerFootstepsEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
