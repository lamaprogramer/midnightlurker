package net.mcreator.midnightlurker.procedures;

import net.minecraft.registry.Registries;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class MidnightLurkerEntityIsHurtProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
			if (world instanceof World _level) {
				if (!_level.isClient()) {
					_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
				} else {
					_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1, false);
				}
			}
			if (!entity.getWorld().isClient())
				entity.discard();
			if (world instanceof ServerWorld _level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(_level, BlockPos.ofFloored(x, y, z), SpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setVelocity(0, 0, 0);
				}
			}
		}
	}
}
