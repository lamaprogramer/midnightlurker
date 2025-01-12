package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

public class MidnightLurkerBackturnedModel extends GeoModel<MidnightLurkerBackturnedEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerBackturnedEntity entity) {
		return Identifier.of("midnightlurker", "animations/midnightlurkerbackturned.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerBackturnedEntity entity) {
		return Identifier.of("midnightlurker", "geo/midnightlurkerbackturned.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerBackturnedEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
