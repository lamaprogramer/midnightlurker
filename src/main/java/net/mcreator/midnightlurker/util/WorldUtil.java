package net.mcreator.midnightlurker.util;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

public class WorldUtil {
    public static boolean isInDimension(WorldAccess worldAccess, RegistryKey<DimensionType> dimensionType) {
        return (worldAccess instanceof World world ? world.getDimensionEntry().getKey().get() : DimensionTypes.OVERWORLD) == dimensionType;
    }
}
