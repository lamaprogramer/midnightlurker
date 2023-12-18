package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;

public class MidnightLurkerShadowEyesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("LightLevelRandom") < 8 && world.getMaxLocalRawBrightness(new BlockPos(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (!entity.level.isClientSide())
				entity.discard();
		} else if (entity.getPersistentData().getDouble("LightLevelRandom") > 7 && world.getMaxLocalRawBrightness(new BlockPos(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MidnightLurkerUnprovokedEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get(), _level);
				entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (!entity.level.isClientSide())
				entity.discard();
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
			entity.getPersistentData().putDouble("LightLevelRandom", (Mth.nextDouble(RandomSource.create(), 1, 10)));
		}
	}
}
