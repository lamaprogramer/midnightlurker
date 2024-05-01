package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.*;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionTypes;

public class SpookyambienceentityNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == DimensionTypes.OVERWORLD && Math.random() > 0.9
                && (!world.getEntitiesByClass(MidnightLurkerFakerEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerFakerAggroEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerFakerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerShadowEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerShadowEyesEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
                || !world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty())
                || (world instanceof World _lvl ? _lvl.getDimensionEntry().getKey().get() : World.OVERWORLD) == World.NETHER && Math.random() > 0.9
                && !world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty();
    }
}
