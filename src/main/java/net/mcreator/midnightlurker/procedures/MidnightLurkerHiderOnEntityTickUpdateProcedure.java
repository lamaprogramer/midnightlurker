package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerHiderOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("desert")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("beach"))) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehidersand");
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_slopes")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_beach"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("snowy_taiga"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("ice_spikes"))) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehidersnow");
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("badlands"))) {
			if (entity instanceof MidnightLurkerHiderEntity animatable)
				animatable.setTexture("midnightlurkervoidgatehiderredsand");
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 255, false, false));
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, (-0.2)));
		}
		if (!entity.isShiftKeyDown()) {
			if (Math.random() > 0.9) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
			}
		}
		if (entity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(MobEffects.LUCK)) {
			entity.setShiftKeyDown(true);
		} else if (!(entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(MobEffects.LUCK))) {
			entity.setShiftKeyDown(false);
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			MidnightlurkerMod.queueServerWork(200, () -> {
				if (entity.getPersistentData().getDouble("SoundActivate") < 3 && !world.getEntitiesOfClass(MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
					entity.getPersistentData().putDouble("SoundActivate", (entity.getPersistentData().getDouble("SoundActivate") + 1));
				}
				if (entity.getPersistentData().getDouble("SoundActivate") == 1) {
					MidnightlurkerMod.queueServerWork(2, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					});
					MidnightlurkerMod.queueServerWork(7, () -> {
						if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER)
								|| !((world.getBlockState(BlockPos.containing(x, y - 0, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.containing(x, y - 0, z))).getBlock() == Blocks.WATER)) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new VoidGatewayEntity(MidnightlurkerModEntities.VOID_GATEWAY.get(), _level);
								entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), world.getRandom().nextFloat() * 360F, 0);
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					});
				}
				if (entity instanceof MidnightLurkerHiderEntity) {
					((MidnightLurkerHiderEntity) entity).setAnimation("teleport8");
				}
				MidnightlurkerMod.queueServerWork(14, () -> {
					if (!entity.level.isClientSide())
						entity.discard();
				});
			});
		}
	}
}
