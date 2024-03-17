package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.registry.Registries;

import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.MathHelper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class InvisibleCaveSoundsOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (!entity.getWorld().isClient())
				entity.discard();
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundTime") < 1200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundTime") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundTime") == 1200) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundTime", 0);
			if (Math.random() > 0.5) {
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(x, y, z), SoundEvents.AMBIENT_CAVE.value(), SoundCategory.AMBIENT, 50, (float) MathHelper.nextDouble(Random.create(), 0.2, 1));
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), SoundEvents.AMBIENT_CAVE.value(), SoundCategory.AMBIENT, 50, (float) MathHelper.nextDouble(Random.create(), 0.2, 1), false);
					}
				}
			}
		}
	}
}
