package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class LurkerSpawnCloseProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		double Spawndeterminer = 0;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("lurker_spawn_close").getAsBoolean() == true) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).CloseSpawnTimer > 1
							&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).CloseSpawnTimer < 100) {
						if (!(!world.getEntitiesOfClass(MidnightLurkerShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
								&& !(!world.getEntitiesOfClass(MidnightLurkerShadowEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
							if (entity instanceof Player) {
								if (((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 1
										|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 2
										|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 3
										|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 4
										|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 5
										|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 6) && y > 0
										&& ((world instanceof Level _lvl6 && _lvl6.isDay()) == false || world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0) && (entity.level.dimension()) == Level.OVERWORLD) {
									if (!(!world.getEntitiesOfClass(MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
										spawnx = x + Mth.nextInt(RandomSource.create(), -30, 30);
										spawny = y + Mth.nextInt(RandomSource.create(), -30, 30);
										spawnz = z + Mth.nextInt(RandomSource.create(), -30, 30);
									}
									if (!(!world.getEntitiesOfClass(MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
										Spawndeterminer = Mth.nextInt(RandomSource.create(), 1, 9);
									}
									if (Spawndeterminer == 1 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerBackturnedEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_BACKTURNED.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 2 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerHiderEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 3 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerInvisibleEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_INVISIBLE.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 4 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerRunawayEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_RUNAWAY.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 5 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerSeenAngressiveEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_SEEN_ANGRESSIVE.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 6 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerStalkingEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 7 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerStareEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_STARE.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 8 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerUnprovokedEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									} else if (Spawndeterminer == 9 && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz))
											&& world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new MidnightLurkerWatcherEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_WATCHER.get(), _level);
											entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											_level.addFreshEntity(entityToSpawn);
										}
									}
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
