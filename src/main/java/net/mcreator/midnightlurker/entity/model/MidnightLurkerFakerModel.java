package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.cache.object.GeoBone;



import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;

public class MidnightLurkerFakerModel extends GeoModel<MidnightLurkerFakerEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerFakerEntity entity) {
		return Identifier.of("midnightlurker", "animations/midnightlurkerfaker.animation.json");
	}

	@Override
	public Identifier getModelResource(MidnightLurkerFakerEntity entity) {
		return Identifier.of("midnightlurker", "geo/midnightlurkerfaker.geo.json");
	}

	@Override
	public Identifier getTextureResource(MidnightLurkerFakerEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
