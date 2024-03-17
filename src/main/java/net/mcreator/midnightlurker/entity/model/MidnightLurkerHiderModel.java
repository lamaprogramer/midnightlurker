package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

public class MidnightLurkerHiderModel extends GeoModel<MidnightLurkerHiderEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerHiderEntity entity) {
		return new Identifier("midnightlurker", "animations/midnightlurkerhide.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerHiderEntity entity) {
		return new Identifier("midnightlurker", "geo/midnightlurkerhide.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerHiderEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
