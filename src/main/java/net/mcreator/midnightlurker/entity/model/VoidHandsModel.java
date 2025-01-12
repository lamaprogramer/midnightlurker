package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;

public class VoidHandsModel extends GeoModel<VoidHandsEntity> {
	@Override
	public Identifier getAnimationResource(VoidHandsEntity entity) {
		return Identifier.of("midnightlurker", "animations/lurands.animation.json");
	}

	@Override
	public Identifier getModelResource(VoidHandsEntity entity) {
		return Identifier.of("midnightlurker", "geo/lurands.geo.json");
	}

	@Override
	public Identifier getTextureResource(VoidHandsEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
