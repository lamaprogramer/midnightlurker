package net.mcreator.midnightlurker.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.RaycastContext;

public class BlockUtil {
    public static BlockHitResult raycast(Entity entity, double rayDistance) {
        return entity.getWorld().raycast(
                new RaycastContext(
                        entity.getCameraPosVec(1f),
                        entity.getCameraPosVec(1f)
                                .add(entity.getRotationVec(1f)
                                        .multiply(rayDistance)
                                ),
                        RaycastContext.ShapeType.COLLIDER,
                        RaycastContext.FluidHandling.NONE,
                        entity
                )
        );
    }
}
