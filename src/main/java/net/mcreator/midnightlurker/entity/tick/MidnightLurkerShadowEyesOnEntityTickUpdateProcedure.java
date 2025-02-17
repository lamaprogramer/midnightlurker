package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerShadowEyesOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("LightLevelRandom") < 8 && world.getLightLevel(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (!entity.getWorld().isClient())
				entity.discard();

			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 25)) {
				IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
				if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
					dataSaver.getPersistentData().putDouble("JumpscareActive", 1);
				}
			}
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("LightLevelRandom") > 7 && world.getLightLevel(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (world instanceof ServerWorld level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYaw(entity.getYaw());
					entityToSpawn.setBodyYaw(entity.getYaw());
					entityToSpawn.setHeadYaw(entity.getYaw());
					entityToSpawn.setPitch(entity.getPitch());
				}
			}

			if (!entity.getWorld().isClient())
				entity.discard();

		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty() && ((IEntityDataSaver)entity).getPersistentData().getDouble("LightLevelRandom") < 8
				&& ((EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET)) {
			if (!entity.getWorld().isClient())
				entity.discard();

			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 25)) {
				IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
				if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
					dataSaver.getPersistentData().putDouble("JumpscareActive", 1);
				}
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty() && ((IEntityDataSaver)entity).getPersistentData().getDouble("LightLevelRandom") > 7
				&& ((EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
						|| (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET)) {
			if (world instanceof ServerWorld level) {
				Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED.spawn(level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYaw(entity.getYaw());
					entityToSpawn.setBodyYaw(entity.getYaw());
					entityToSpawn.setHeadYaw(entity.getYaw());
					entityToSpawn.setPitch(entity.getPitch());
				}
			}

			if (!entity.getWorld().isClient())
				entity.discard();
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 25)) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("LightLevelRandom", (MathHelper.nextDouble(Random.create(), 1, 10)));
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 80)) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") < 300) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundLurk", (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld level)
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.5");
				}
			}
		}
	}
}
