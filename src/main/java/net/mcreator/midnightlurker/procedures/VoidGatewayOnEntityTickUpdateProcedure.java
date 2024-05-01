package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.SimpleParticleType;
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

public class VoidGatewayOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") >= 1) {
			if (entity instanceof VoidGatewayEntity) {
				((VoidGatewayEntity) entity).setAnimation("gatewayclose");
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") >= 9) {
			if (!entity.getWorld().isClient())
				entity.discard();
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") <= 0 && !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("PlayerActivationGateway", (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") >= 1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") < 9) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("CloseTime", (((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") == 4) {
			if (world instanceof World _level) {
				if (!_level.isClient()) {
					_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
				} else {
					_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") >= 1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") == 6) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom = MathHelper.nextDouble(Random.create(), 1, 10);
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") >= 1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") == 8) {
			if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom < 8 && ((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
						IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
						if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
								dataSaver.getPersistentData().putDouble("encounternumber", _setval);
								dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
							}
						}
					}
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
						if (Math.random() > 0.7) {
							IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
							if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
								{
									double _setval = 1;
									dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
									dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
								}
							}
						}
					}
				});
			} else if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom > 7 && ((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:insanitygoesbacksound")), SoundCategory.NEUTRAL, 1, 1);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:insanitygoesbacksound")), SoundCategory.NEUTRAL, 1, 1, false);
						}
					}
					if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
						IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
						if (dataSaver.getPersistentData().getDouble("InsanityStage") > 0) {
							{
								double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") - 1;
								dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
								dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
							}
						}
					}
				});
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE), x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 60, 255, false, false));
	}
}
