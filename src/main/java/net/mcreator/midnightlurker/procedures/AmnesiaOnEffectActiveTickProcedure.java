package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.BlockUtil;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class AmnesiaOnEffectActiveTickProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		boolean entity_found = false;
        for (int index0 = 0; index0 < 30; index0++) {
			BlockHitResult blockHit = BlockUtil.raycast(entity, raytrace_distance);
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, new Vec3d((blockHit.getBlockPos().getX()), (blockHit.getBlockPos().getY()), (blockHit.getBlockPos().getZ())), 25) && !(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == entity)) {
				entity_found = true;
			} else {
				entity_found = false;
				raytrace_distance++;
			}
		}

		if (entity_found) {
			BlockHitResult blockHit = BlockUtil.raycast(entity, raytrace_distance);
			if (!(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == null)) {
				SoundUtil.playsound(world, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
			}
		} else {
			if (EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, entity.getPos(), 10)) {
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, entity.getPos(), 30)) {
					if (!EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, entity.getPos(), 30, 30, 30).getWorld().isClient()) {
						EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, entity.getPos(), 30, 30, 30).discard();
					}
				}
			}
		}
	}
}
