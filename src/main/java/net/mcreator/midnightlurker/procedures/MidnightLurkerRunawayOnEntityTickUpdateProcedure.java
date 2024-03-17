package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerRunawayOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(400, () -> {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate2") < 3 && !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("SoundActivate2", (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate2") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("SoundActivate2") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof World _level) {
							if (!_level.isClient()) {
								_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
							} else {
								_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerRunawayEntity) {
					((MidnightLurkerRunawayEntity) entity).setAnimation("teleport6");
				}
				MidnightlurkerMod.queueServerWork(13, () -> {
					if (!entity.getWorld().isClient())
						entity.discard();
				});
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles((DefaultParticleType) (MidnightlurkerModParticleTypes.VOID_DOT), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasStatusEffect(StatusEffects.SLOWNESS)
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty()) {
            _livEnt22.removeStatusEffect(StatusEffects.SLOWNESS);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 23, 23, 23), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 23, 23, 23), entity, 23) instanceof MidnightLurkerRunawayEntity) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeStatusEffect(StatusEffects.SLOWNESS);
			}
		}
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.EAST) {
			entity.setVelocity(new Vec3d(0.2, 0.2, (entity.getVelocity().z)));
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.WEST) {
			entity.setVelocity(new Vec3d((-0.2), 0.2, (entity.getVelocity().z)));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().x), 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.NORTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().x), 0.2, (-0.2)));
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("encount", (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") + 1));
			}
		}

		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") == 1) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					}
				}
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).hasVehicle()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 255, false, false));
			}
		}
	}
}
