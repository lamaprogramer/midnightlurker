package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

public class MidnightLurkerHiderModel extends GeoModel<MidnightLurkerHiderEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerHiderEntity entity) {
		return Identifier.of("midnightlurker", "animations/midnightlurkerhide.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerHiderEntity entity) {
		return Identifier.of("midnightlurker", "geo/midnightlurkerhide.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerHiderEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
