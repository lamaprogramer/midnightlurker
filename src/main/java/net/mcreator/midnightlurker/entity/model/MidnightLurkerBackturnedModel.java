package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

public class MidnightLurkerBackturnedModel extends GeoModel<MidnightLurkerBackturnedEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerBackturnedEntity entity) {
		return new Identifier("midnightlurker", "animations/midnightlurkerbackturned.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerBackturnedEntity entity) {
		return new Identifier("midnightlurker", "geo/midnightlurkerbackturned.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerBackturnedEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
