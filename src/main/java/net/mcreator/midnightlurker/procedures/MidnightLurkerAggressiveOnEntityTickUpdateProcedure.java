package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerAggressiveOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SPRUCE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SPRUCE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SPRUCE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SPRUCE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BIRCH_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BIRCH_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BIRCH_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BIRCH_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.JUNGLE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.JUNGLE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.JUNGLE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.JUNGLE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.ACACIA_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.ACACIA_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.ACACIA_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.ACACIA_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.DARK_OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.DARK_OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.DARK_OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.DARK_OAK_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CRIMSON_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CRIMSON_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CRIMSON_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CRIMSON_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WARPED_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WARPED_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WARPED_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WARPED_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		MidnightlurkerMod.queueServerWork(1200, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
