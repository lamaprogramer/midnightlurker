package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
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
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawny = 0;
		double spawnz = 0;
		if (world instanceof World _lvl0 && _lvl0.isDay() && y < 60) {
			if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 7) {
				if (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
					spawnx = x + MathHelper.nextInt(Random.create(), -12, 12);
					spawny = y + MathHelper.nextInt(Random.create(), -12, 12);
					spawnz = z + MathHelper.nextInt(Random.create(), -12, 12);
				}
				if (world.isAir(BlockPos.ofFloored(spawnx, spawny + 0, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 2, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 3, spawnz))
						&& !world.isAir(BlockPos.ofFloored(spawnx, spawny - 1, spawnz))) {
					if (world instanceof ServerWorld _level) {
						Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.spawn(_level, BlockPos.ofFloored(spawnx, spawny, spawnz), SpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setVelocity(0, 0, 0);
						}
					}
				}
			}
			if (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
				if (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") < 3) {
					((IEntityDataSaver) entity).getPersistentData().putDouble("DistantRoar", (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") + 1));
					if (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") == 1) {
						{
							double _setval = 60;
							IEntityDataSaver data = (IEntityDataSaver) entity;
							data.getPersistentData().putDouble("ScreenShake", _setval);
							data.syncPlayerVariables(entity);
						}
						MidnightlurkerMod.queueServerWork(1, () -> {
                            World _level = (World) world;
                            if (!_level.isClient()) {
                                _level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdistantscream")), SoundCategory.NEUTRAL, 1, 1);
                            } else {
                                _level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdistantscream")), SoundCategory.NEUTRAL, 1, 1, false);
                            }
                        });
					}
				}
			}
			if (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && ((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") > 0) {
				((IEntityDataSaver) entity).getPersistentData().putDouble("DistantRoar", 0);
			}
		} else if (!(world instanceof World _lvl20 && _lvl20.isDay())) {
			if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 7) {
				if (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
					spawnx = x + MathHelper.nextInt(Random.create(), -12, 12);
					spawny = y + MathHelper.nextInt(Random.create(), -12, 12);
					spawnz = z + MathHelper.nextInt(Random.create(), -12, 12);
				}
				if (world.isAir(BlockPos.ofFloored(spawnx, spawny + 0, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 2, spawnz)) && world.isAir(BlockPos.ofFloored(spawnx, spawny + 3, spawnz))
						&& !world.isAir(BlockPos.ofFloored(spawnx, spawny - 1, spawnz))) {
					if (world instanceof ServerWorld _level) {
						Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.spawn(_level, BlockPos.ofFloored(spawnx, spawny, spawnz), SpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setVelocity(0, 0, 0);
						}
					}
				}
			}
			if (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
				if (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") < 3) {
					((IEntityDataSaver) entity).getPersistentData().putDouble("DistantRoar", (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") + 1));
					if (((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") == 1) {
						{
							double _setval = 60;
							IEntityDataSaver data = (IEntityDataSaver) entity;
							data.getPersistentData().putDouble("ScreenShake", _setval);
							data.syncPlayerVariables(entity);
						}
						MidnightlurkerMod.queueServerWork(1, () -> {
							if (world instanceof World _level) {
								if (!_level.isClient()) {
									_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdistantscream")), SoundCategory.NEUTRAL, 1, 1);
								} else {
									_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdistantscream")), SoundCategory.NEUTRAL, 1, 1, false);
								}
							}
						});
					}
				}
			}
			if (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty() && ((IEntityDataSaver) entity).getPersistentData().getDouble("DistantRoar") > 0) {
				((IEntityDataSaver) entity).getPersistentData().putDouble("DistantRoar", 0);
			}
		}
	}
}
