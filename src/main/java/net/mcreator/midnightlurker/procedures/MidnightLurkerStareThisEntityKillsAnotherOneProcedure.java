package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerStareThisEntityKillsAnotherOneProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof World level) {
			if (!level.isClient()) {
				level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
			} else {
				level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
			}
		}
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
				if (!EntityUtil.getPlayerEntityWithMinDistanceOf(MidnightLurkerStareEntity.class, world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).getWorld().isClient())
					EntityUtil.getPlayerEntityWithMinDistanceOf(MidnightLurkerStareEntity.class, world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).discard();
			}
		});
	}
}
