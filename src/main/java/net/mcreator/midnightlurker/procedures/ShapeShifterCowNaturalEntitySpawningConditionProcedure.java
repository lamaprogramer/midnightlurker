package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.passive.CowEntity;

import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;

public class ShapeShifterCowNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return !world.getEntitiesByClass(CowEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && (world.getEntitiesByClass(ShapeShifterCowEntity.class, Box.of(new Vec3d(x, y, z), 200, 200, 200), e -> true).isEmpty());
    }
}
