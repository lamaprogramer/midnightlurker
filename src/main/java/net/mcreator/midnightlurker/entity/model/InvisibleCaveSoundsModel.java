package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;

public class InvisibleCaveSoundsModel extends GeoModel<InvisibleCaveSoundsEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleCaveSoundsEntity entity) {
		return Identifier.of("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleCaveSoundsEntity entity) {
		return Identifier.of("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleCaveSoundsEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
