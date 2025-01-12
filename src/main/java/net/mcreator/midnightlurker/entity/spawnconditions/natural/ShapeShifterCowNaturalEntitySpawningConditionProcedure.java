package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class ShapeShifterCowNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return !EntityUtil.hasNoEntityOfTypeInArea(world, CowEntity.class, new Vec3d(x, y, z), 100)
                && EntityUtil.hasNoEntityOfTypeInArea(world, ShapeShifterCowEntity.class, new Vec3d(x, y, z), 200);
    }
}
