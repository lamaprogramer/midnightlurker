package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;

public class InvisibleLurkerFootstepsModel extends GeoModel<InvisibleLurkerFootstepsEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleLurkerFootstepsEntity entity) {
		return new Identifier("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleLurkerFootstepsEntity entity) {
		return new Identifier("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleLurkerFootstepsEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
