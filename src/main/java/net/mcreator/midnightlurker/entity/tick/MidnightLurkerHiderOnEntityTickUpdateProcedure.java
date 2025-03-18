package net.mcreator.midnightlurker.entity.tick;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.mcreator.midnightlurker.entity.AnimatableHostileMidnightLurkerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.mcreator.midnightlurker.util.animations.Animations;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class MidnightLurkerHiderOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		
		Map<TagKey<Biome>, String> camouflageMap = new HashMap<>();
		camouflageMap.put(ConventionalBiomeTags.IS_DESERT, "midnightlurkervoidgatehidersand");
		camouflageMap.put(ConventionalBiomeTags.IS_BEACH, "midnightlurkervoidgatehidersand");
		camouflageMap.put(ConventionalBiomeTags.IS_SNOWY, "midnightlurkervoidgatehidersnow");
		camouflageMap.put(ConventionalBiomeTags.IS_BADLANDS, "midnightlurkervoidgatehiderredsand");

		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		handleCamouflage(entity, camouflageMap, world.getBiome(BlockPos.ofFloored(x, y, z)));

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 30)) {
			EntityTickActions.handleEffect(entity, StatusEffects.SLOWNESS, 60, 255, false, false);
		}

		if (!entity.isSneaking()) {
			EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}

		handleHiding(world, x, y, z, entity);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
			PlayerEntity player = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 70, 70, 70);
			entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, player.getPos());
		}

		EntityTickActions.handleClimbing(world, entity, x ,y ,z);
		EntityTickActions.handleEncounter(world, entity, entityData, x, y, z);
	}

	private static void handleCamouflage(Entity entity, Map<TagKey<Biome>, String> camoMap, RegistryEntry<Biome> biome) {
		for (Map.Entry<TagKey<Biome>, String> entry : camoMap.entrySet()) {
			if (biome.isIn(entry.getKey())) {
				if (entity instanceof AnimatableHostileMidnightLurkerEntity animatable) {
					animatable.setTexture(entry.getValue());
				}
			}
		}
	}

	private static void handleTeleport(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);

			if (!((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER)
					|| !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER)) {
				if (world instanceof ServerWorld level) {
					Entity entityToSpawn = MidnightlurkerModEntities.VOID_GATEWAY.spawn(level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYaw(world.getRandom().nextFloat() * 360F);
					}
				}
			}

			if (entity instanceof MidnightLurkerHiderEntity) {
				((MidnightLurkerHiderEntity) entity).setAnimation(Animations.TELEPORT_1);
			}

			if (!entity.getWorld().isClient())
				entity.discard();
		}
	}


	private static void handleHiding(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		entity.setSneaking(entityData.getPersistentData().getBoolean("Hiding"));

		handleTeleport(world, x, y ,z, entity);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70)) {
			Direction[] directions = {Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST};
			for (Direction direction : directions) {
				Direction entityFacing = entity.getHorizontalFacing();
				Direction playerFacing = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 70, 70, 70).getHorizontalFacing();

				entityData.getPersistentData().putBoolean("Hiding", entityFacing == direction && playerFacing == direction.getOpposite());
			}
		}
	}
}
