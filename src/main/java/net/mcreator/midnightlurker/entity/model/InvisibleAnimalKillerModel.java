package net.mcreator.midnightlurker.entity.model;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;

public class InvisibleAnimalKillerModel extends GeoModel<InvisibleAnimalKillerEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleAnimalKillerEntity entity) {
		return new Identifier("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleAnimalKillerEntity entity) {
		return new Identifier("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleAnimalKillerEntity entity) {
		return new Identifier("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
