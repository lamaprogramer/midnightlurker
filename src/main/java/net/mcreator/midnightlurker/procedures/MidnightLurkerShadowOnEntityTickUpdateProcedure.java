package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerShadowOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLightLevel(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ())) > 1) {
			if (!entity.getWorld().isClient())
				entity.discard();
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
			if ((EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.REDSTONE_TORCH.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SOUL_LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.BLAZE_ROD
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Blocks.SEA_LANTERN.asItem()
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
					|| (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 10, 10, 10) instanceof LivingEntity _livEnt ? _livEnt.getOffHandStack() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET) {
				if (!entity.getWorld().isClient())
					entity.discard();
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 35, 35, 35), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 250, false, false));
		}
	}
}
