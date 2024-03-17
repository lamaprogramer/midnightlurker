package net.mcreator.midnightlurker.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


import java.util.Comparator;

public class EntityUtil {
    public static  Entity getEntityWithMinDistanceOf(WorldAccess world, Vec3d center, double dx, double dy, double dz) {
        return getEntityWithMinDistanceOf(PlayerEntity.class, world, center, dx, dy, dz);
    }

    public static <T extends Entity> Entity getEntityWithMinDistanceOf(Class<T> type, WorldAccess world, BlockPos center, double cubeBounds) {
        return getEntityWithMinDistanceOf(type, world, center, cubeBounds, cubeBounds, cubeBounds);
    }

    public static <T extends Entity> Entity getEntityWithMinDistanceOf(Class<T> type, WorldAccess world, BlockPos center, double dx, double dy, double dz) {
        return getEntityWithMinDistanceOf(type, world, new Vec3d(center.getX(), center.getY(), center.getZ()), dx, dy, dz);
    }

    public static <T extends Entity> Entity getEntityWithMinDistanceOf(Class<T> type, WorldAccess world, Vec3d center, double dx, double dy, double dz) {
        return world.getEntitiesByClass(type, Box.of(center, dx, dy, dz), e -> true)
                .stream()
                .min(compareDistOf(center.getX(), center.getY(), center.getZ()))
                .orElse(null);
    }

    public static Entity getEntityWithRaycast(Entity player, Entity entity, double entityReach) {
        double distance = entityReach * entityReach;
        Vec3d eyePos = player.getCameraPosVec(1.0f);
        HitResult hitResult = entity.raycast(entityReach, 1.0f, false);
        if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
            distance = hitResult.getPos().squaredDistanceTo(eyePos);
            double blockReach = 5;
            if (distance > blockReach * blockReach) {
                Vec3d pos = hitResult.getPos();
                hitResult = BlockHitResult.createMissed(pos, Direction.getFacing(eyePos.x, eyePos.y, eyePos.z), BlockPos.ofFloored(pos));
            }
        }
        Vec3d viewVec = player.getRotationVec(1.0F);
        Vec3d toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
        Box aabb = entity.getBoundingBox().stretch(viewVec.multiply(entityReach)).expand(1.0D, 1.0D, 1.0D);
        EntityHitResult entityhitresult = ProjectileUtil.getEntityCollision(player.getWorld(), player, eyePos, toVec, aabb, Entity::isSpectator, (float)distance);
        if (entityhitresult != null) {
            Vec3d targetPos = entityhitresult.getPos();
            double distanceToTarget = eyePos.squaredDistanceTo(targetPos);
            if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
                hitResult = BlockHitResult.createMissed(targetPos, Direction.getFacing(viewVec.x, viewVec.y, viewVec.z), BlockPos.ofFloored(targetPos));
            } else if (distanceToTarget < distance) {
                hitResult = entityhitresult;
            }
        }
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            return ((EntityHitResult) hitResult).getEntity();
        }
        return null;
    }

    private static Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
        return Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_x, _y, _z));
    }

}
