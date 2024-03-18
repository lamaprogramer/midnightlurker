package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.BlockUtil;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AmnesiaOnEffectActiveTickProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		
		if (entity == null)
			return;
		double raytrace_distance = 0;
		boolean entity_found = false;
		BlockHitResult blockHit = BlockUtil.raycast(entity, raytrace_distance);
        for (int index0 = 0; index0 < 30; index0++) {
			if (!world.getEntitiesByClass(HostileEntity.class, Box.of(new Vec3d((blockHit.getBlockPos().getX()), (blockHit.getBlockPos().getY()), (blockHit.getBlockPos().getZ())), 25, 25, 25), e -> true).isEmpty()
					&& !(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == entity)) {
				entity_found = true;
			} else {
				entity_found = false;
				raytrace_distance++;
			}
		}
		if (entity_found) {
			if (!(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == null)) {
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0, false);
					}
				}
			}
		} else {
			if ((world.getEntitiesByClass(HostileEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
				if (!world.getEntitiesByClass(HostileEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
					if (!EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30).getWorld().isClient())
						EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30).discard();
				}
			}
		}
	}
}
