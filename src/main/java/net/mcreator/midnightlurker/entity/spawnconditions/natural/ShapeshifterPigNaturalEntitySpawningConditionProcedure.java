package net.mcreator.midnightlurker.entity.spawnconditions.natural;

import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class ShapeshifterPigNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return !EntityUtil.hasNoEntityOfTypeInArea(world, PigEntity.class, new Vec3d(x, y, z), 100)
                && EntityUtil.hasNoEntityOfTypeInArea(world, ShapeshifterPigEntity.class, new Vec3d(x, y, z), 200);
    }
}
