package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.WorldUtil;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

public class InvisibleFootstepsNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
		boolean spawnInvisibleEntities = MidnightlurkerMod.CONFIG.shouldDoInvisibleEntitiesSpawning();

		if (spawnInvisibleEntities) {
			SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0);
			System.out.println("Tried spawning");
			return EntityUtil.hasNoEntityOfTypeInArea(world, InvisibleFootstepsEntity.class, new Vec3d(x, y, z), 800)
					&& EntityUtil.hasNoEntityOfTypeInArea(world, InvisibleShadowEntity.class, new Vec3d(x, y, z), 800)
					&& EntityUtil.hasNoEntityOfTypeInArea(world, InvisibleStaticEntity.class, new Vec3d(x, y, z), 800)
					&& EntityUtil.hasNoEntityOfTypeInArea(world, InvisibleLurkerFootstepsEntity.class, new Vec3d(x, y, z), 800)
					&& EntityUtil.hasNoEntityOfTypeInArea(world, InvisibleCaveSoundsEntity.class, new Vec3d(x, y, z), 800)
					&& WorldUtil.isInDimension(world, DimensionTypes.OVERWORLD);
		} else {
			SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerchase")), SoundCategory.NEUTRAL, 0, 0);
			return false;
		}
	}
}
