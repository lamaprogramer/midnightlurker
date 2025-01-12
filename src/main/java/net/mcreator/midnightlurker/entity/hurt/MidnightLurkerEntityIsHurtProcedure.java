package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerEntityIsHurtProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
			SoundUtil.playsound(world, x, y ,z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 1, 1);
			if (!entity.getWorld().isClient())
				entity.discard();
			if (world instanceof ServerWorld level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(x, y, z), SpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setVelocity(0, 0, 0);
				}
			}
		}
	}
}
