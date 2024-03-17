package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;

import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import java.io.File;

public class SpookyambienceentityNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return (world instanceof World _lvl ? _lvl.getDimension() : World.OVERWORLD) == World.OVERWORLD && Math.random() > 0.9
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
                || (world instanceof World _lvl ? _lvl.getDimension() : World.OVERWORLD) == World.NETHER && Math.random() > 0.9
                && !world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty();
    }
}
