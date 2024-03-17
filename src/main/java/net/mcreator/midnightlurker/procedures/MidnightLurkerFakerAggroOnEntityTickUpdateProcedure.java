package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerFakerAggroOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (!entity.getWorld().isClient())
				entity.discard();
			
			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
				double _setval = 1;
				dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
				dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
			}
			if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
				
				double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;

				dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
				dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));

				dataSaver.getPersistentData().putDouble("InsanityTimer", 0);
				dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x + 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.EAST) {
			entity.setVelocity(new Vec3d(0.2, 0.2, (entity.getVelocity().getZ())));
		} else if (world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x - 1, y + 0, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.WEST) {
			entity.setVelocity(new Vec3d((-0.2), 0.2, (entity.getVelocity().getZ())));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z + 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.SOUTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().getX()), 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1)).isOpaque() && !(world.getBlockState(BlockPos.ofFloored(x, y + 0, z - 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:cannotclimb")))
				&& (!world.getBlockState(BlockPos.ofFloored(x, y + 2, z)).isOpaque() || !world.getBlockState(BlockPos.ofFloored(x, y + 3, z)).isOpaque())
				&& !world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getHorizontalFacing()) == Direction.NORTH) {
			entity.setVelocity(new Vec3d((entity.getVelocity().getX()), 0.2, (-0.2)));
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 70, 70, 70).hasVehicle()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 255, false, false));
			}
		}
	}
}
