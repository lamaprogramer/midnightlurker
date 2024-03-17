package net.mcreator.midnightlurker.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.passive.PigEntity;

import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;

public class ShapeshifterPigNaturalEntitySpawningConditionProcedure {
	public static boolean execute(WorldAccess world, double x, double y, double z) {
        return !world.getEntitiesByClass(PigEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && (world.getEntitiesByClass(ShapeshifterPigEntity.class, Box.of(new Vec3d(x, y, z), 200, 200, 200), e -> true).isEmpty());
    }
}
