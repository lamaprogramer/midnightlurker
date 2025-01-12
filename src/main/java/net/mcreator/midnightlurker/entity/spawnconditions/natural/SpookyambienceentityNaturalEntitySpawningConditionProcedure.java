package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.WorldUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

public class SpookyambienceentityNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return WorldUtil.isInDimension(world, DimensionTypes.OVERWORLD) && Math.random() > 0.9
                && (!EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerFakerEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerFakerAggroEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerFakerWatcherEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerInvisibleEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerSeenAngressiveEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerStalkingEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerBackturnedEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerHiderEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerRunawayEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerShadowEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerShadowEyesEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerShapeshifterEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerUnprovokedEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkertposeEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerStareEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerWatcherEntity.class, new Vec3d(x, y, z), 700)
                || !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 700))
                || WorldUtil.isInDimension(world, DimensionTypes.THE_NETHER) && Math.random() > 0.9
                && !EntityUtil.hasNoEntityOfTypeInArea(world, MidnightlurkerNEEntity.class, new Vec3d(x, y, z), 700);
    }
}
