package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;

public class MidnightLurkerShadowModel extends GeoModel<MidnightLurkerShadowEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerShadowEntity entity) {
		return new Identifier("midnightlurker", "animations/midnightlurkershadow.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerShadowEntity entity) {
		return new Identifier("midnightlurker", "geo/midnightlurkershadow.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerShadowEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
