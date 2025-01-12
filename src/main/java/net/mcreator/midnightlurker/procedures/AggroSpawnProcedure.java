package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AggroSpawnProcedure {
	public static void execute(WorldAccess worldAccess, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		double spawnx = 0;
		double spawny = 0;
		double spawnz = 0;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (worldAccess instanceof World world) {
			if (!world.isDay() || y < 60) {
				if (entityData.getPersistentData().getDouble("InsanityStage") == 7) {
					if (EntityUtil.hasNoEntityOfTypeInArea(worldAccess, MidnightLurkerAggressiveEntity.class, new Vec3d(x, y, z), 700)) {
						spawnx = x + MathHelper.nextInt(Random.create(), -12, 12);
						spawny = y + MathHelper.nextInt(Random.create(), -12, 12);
						spawnz = z + MathHelper.nextInt(Random.create(), -12, 12);
					}
					if (worldAccess.isAir(BlockPos.ofFloored(spawnx, spawny + 0, spawnz)) && worldAccess.isAir(BlockPos.ofFloored(spawnx, spawny + 2, spawnz)) && worldAccess.isAir(BlockPos.ofFloored(spawnx, spawny + 3, spawnz)) && !worldAccess.isAir(BlockPos.ofFloored(spawnx, spawny - 1, spawnz))) {
						if (worldAccess instanceof ServerWorld level) {
							Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.spawn(level, BlockPos.ofFloored(spawnx, spawny, spawnz), SpawnReason.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setVelocity(0, 0, 0);
							}
						}
					}
				}

				if (!EntityUtil.hasNoEntityOfTypeInArea(worldAccess, MidnightLurkerAggressiveEntity.class, new Vec3d(x, y, z), 100)) {
					if (entityData.getPersistentData().getDouble("DistantRoar") < 3) {
						entityData.getPersistentData().putDouble("DistantRoar", (entityData.getPersistentData().getDouble("DistantRoar") + 1));
						if (entityData.getPersistentData().getDouble("DistantRoar") == 1) {
							entityData.getPersistentData().putDouble("ScreenShake", 60);
							SoundUtil.playsound(worldAccess, x, y, z, Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdistantscream")), SoundCategory.NEUTRAL, 1, 1);
						}
					}
				}

				if (worldAccess.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && entityData.getPersistentData().getDouble("DistantRoar") > 0) {
					entityData.getPersistentData().putDouble("DistantRoar", 0);
				}
			}
		}
	}
}
