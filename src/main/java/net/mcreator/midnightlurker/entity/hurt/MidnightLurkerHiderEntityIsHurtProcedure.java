package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class MidnightLurkerHiderEntityIsHurtProcedure {

	public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return true;

		CoreConfig config = MidnightlurkerMod.CONFIG;

		if (config.isLurkerInvulnerable()) {
			if (sourceentity instanceof PlayerEntity) {
				return false;
			}
		}

		if (entity instanceof MidnightLurkerHiderEntity && sourceentity instanceof PlayerEntity) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
				SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
                ((MidnightLurkerHiderEntity) entity).setAnimation("teleport");

				if (!entity.getWorld().isClient()) {
					entity.discard();

					if (!(world.getBlockState(BlockPos.ofFloored(x, y - 1, z)).getBlock() == Blocks.WATER)
							|| !(world.getBlockState(BlockPos.ofFloored(x, y - 0, z)).getBlock() == Blocks.WATER)) {

						Entity entityToSpawn = MidnightlurkerModEntities.VOID_GATEWAY.spawn((ServerWorld) world, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYaw(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}

		return true;
	}
}
