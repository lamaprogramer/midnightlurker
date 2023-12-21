package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AggroSpawnProcedure {
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
		double spawny = 0;
		double spawnz = 0;
		if (entity.getPersistentData().getDouble("InsanityStage") == 7) {
			if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
				spawnx = x + Mth.nextInt(RandomSource.create(), -12, 12);
				spawny = y + Mth.nextInt(RandomSource.create(), -12, 12);
				spawnz = z + Mth.nextInt(RandomSource.create(), -12, 12);
			}
			if (world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz))
					&& !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new MidnightLurkerAggressiveEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.get(), _level);
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
		if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if (entity.getPersistentData().getDouble("DistantRoar") < 3) {
				entity.getPersistentData().putDouble("DistantRoar", (entity.getPersistentData().getDouble("DistantRoar") + 1));
				if (entity.getPersistentData().getDouble("DistantRoar") == 1) {
					{
						double _setval = 60;
						entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ScreenShake = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MidnightlurkerMod.queueServerWork(1, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
			}
		}
		if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) && entity.getPersistentData().getDouble("DistantRoar") > 0) {
			entity.getPersistentData().putDouble("DistantRoar", 0);
		}
		if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake - 1;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ScreenShake = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
			{
				double _setval = 0;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ScreenShake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
				{
					Entity _ent = entity;
					_ent.setYRot((float) (entity.getYRot() + Mth.nextInt(RandomSource.create(), -1, 1)));
					_ent.setXRot((float) (entity.getXRot() + Mth.nextInt(RandomSource.create(), -1, 1)));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			}
		}
	}
}
