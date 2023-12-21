package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MidnightLurkerAggressiveLoopExternalAnimationsProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude() && world.getBlockState(BlockPos.containing(x + 1, y + 2, z)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) && (entity.getDirection()) == Direction.EAST) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, y + 2, z)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) && (entity.getDirection()) == Direction.WEST) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 2, z + 1)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) && (entity.getDirection()) == Direction.SOUTH) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return true;
			}
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 2, z - 1)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) && (entity.getDirection()) == Direction.NORTH) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return true;
			}
		}
		if (!world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			if (entity.getDeltaMovement().z() > 0 || entity.getDeltaMovement().x() > 0 || entity.getDeltaMovement().z() < 0 || entity.getDeltaMovement().x() < 0) {
				return true;
			}
		}
		return false;
	}
}
