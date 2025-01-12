package net.mcreator.midnightlurker.entity.model;

import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class InvisibleAnimalKillerModel extends GeoModel<InvisibleAnimalKillerEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleAnimalKillerEntity entity) {
		return Identifier.of("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public Identifier getModelResource(InvisibleAnimalKillerEntity entity) {
		return Identifier.of("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public Identifier getTextureResource(InvisibleAnimalKillerEntity entity) {
		return Identifier.of("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}
}
