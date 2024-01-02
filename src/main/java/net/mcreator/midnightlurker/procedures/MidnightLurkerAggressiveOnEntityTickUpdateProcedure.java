package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MidnightLurkerAggressiveOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
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
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.MANGROVE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x + 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.MANGROVE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x - 1, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 0.5, z), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.MANGROVE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z + 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z + 1), null);
				world.destroyBlock(_pos, false);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.MANGROVE_DOOR) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z - 1);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 0.5, z - 1), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3(0.2, 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((-0.2), 0.2, 0));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, 0.2));
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && (!world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 52), z), 100.1, 100.1, 100.1), e -> true).isEmpty() && (entity.getDirection()) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3(0, 0.2, (-0.2)));
		}
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x + 4, y, z)).canOcclude() && entity.getY() < 50) {
			if (entity.getPersistentData().getDouble("LurkerTime") == 0) {
				entity.getPersistentData().putDouble("LurkerTime", 100);
			} else {
				entity.getPersistentData().putDouble("LurkerTime", (entity.getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.destroyBlock(BlockPos.containing(x + 1, y + 0, z), false);
				world.destroyBlock(BlockPos.containing(x + 1, y + 1, z), false);
				world.destroyBlock(BlockPos.containing(x + 1, y + 2, z), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DestroytexEntity(MidnightlurkerModEntities.DESTROYTEX.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5 + 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex2Entity(MidnightlurkerModEntities.DESTROYTEX_2.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5 + 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex3Entity(MidnightlurkerModEntities.DESTROYTEX_3.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5 + 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex4Entity(MidnightlurkerModEntities.DESTROYTEX_4.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5 + 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x - 4, y, z)).canOcclude() && entity.getY() < 50) {
			if (entity.getPersistentData().getDouble("LurkerTime") == 0) {
				entity.getPersistentData().putDouble("LurkerTime", 100);
			} else {
				entity.getPersistentData().putDouble("LurkerTime", (entity.getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.destroyBlock(BlockPos.containing(x - 1, y + 0, z), false);
				world.destroyBlock(BlockPos.containing(x - 1, y + 1, z), false);
				world.destroyBlock(BlockPos.containing(x - 1, y + 2, z), false);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DestroytexEntity(MidnightlurkerModEntities.DESTROYTEX.get(), _level);
					entityToSpawn.moveTo(((Math.floor(x) + 0.5) - 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex2Entity(MidnightlurkerModEntities.DESTROYTEX_2.get(), _level);
					entityToSpawn.moveTo(((Math.floor(x) + 0.5) - 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex3Entity(MidnightlurkerModEntities.DESTROYTEX_3.get(), _level);
					entityToSpawn.moveTo(((Math.floor(x) + 0.5) - 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex4Entity(MidnightlurkerModEntities.DESTROYTEX_4.get(), _level);
					entityToSpawn.moveTo(((Math.floor(x) + 0.5) - 1), Math.floor(y), (Math.floor(z) + 0.5), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y, z + 4)).canOcclude() && entity.getY() < 50) {
			if (entity.getPersistentData().getDouble("LurkerTime") == 0) {
				entity.getPersistentData().putDouble("LurkerTime", 100);
			} else {
				entity.getPersistentData().putDouble("LurkerTime", (entity.getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.destroyBlock(BlockPos.containing(x, y + 0, z + 1), false);
				world.destroyBlock(BlockPos.containing(x, y + 1, z + 1), false);
				world.destroyBlock(BlockPos.containing(x, y + 2, z + 1), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DestroytexEntity(MidnightlurkerModEntities.DESTROYTEX.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), (Math.floor(z) + 0.5 + 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex2Entity(MidnightlurkerModEntities.DESTROYTEX_2.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), (Math.floor(z) + 0.5 + 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex3Entity(MidnightlurkerModEntities.DESTROYTEX_3.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), (Math.floor(z) + 0.5 + 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex4Entity(MidnightlurkerModEntities.DESTROYTEX_4.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), (Math.floor(z) + 0.5 + 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y, z - 4)).canOcclude() && entity.getY() < 50) {
			if (entity.getPersistentData().getDouble("LurkerTime") == 0) {
				entity.getPersistentData().putDouble("LurkerTime", 100);
			} else {
				entity.getPersistentData().putDouble("LurkerTime", (entity.getPersistentData().getDouble("LurkerTime") - 1));
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 1) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				world.destroyBlock(BlockPos.containing(x, y + 0, z - 1), false);
				world.destroyBlock(BlockPos.containing(x, y + 1, z - 1), false);
				world.destroyBlock(BlockPos.containing(x, y + 2, z - 1), false);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerfinalbreak block @a");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerfinalbreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
			if (entity.getPersistentData().getDouble("LurkerTime") == 80) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DestroytexEntity(MidnightlurkerModEntities.DESTROYTEX.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), ((Math.floor(z) + 0.5) - 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 60) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex2Entity(MidnightlurkerModEntities.DESTROYTEX_2.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), ((Math.floor(z) + 0.5) - 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 40) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerbreakingblock block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex3Entity(MidnightlurkerModEntities.DESTROYTEX_3.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), ((Math.floor(z) + 0.5) - 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (entity.getPersistentData().getDouble("LurkerTime") == 20) {
				if (entity instanceof MidnightLurkerAggressiveEntity) {
					((MidnightLurkerAggressiveEntity) entity).setAnimation("breaking1");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/playsound midnightlurker:lurkerprefinalbreak block @a");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Destroytex4Entity(MidnightlurkerModEntities.DESTROYTEX_4.get(), _level);
					entityToSpawn.moveTo((Math.floor(x) + 0.5), Math.floor(y), ((Math.floor(z) + 0.5) - 1), 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (!world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 0, false, false));
		}
		if (!world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 0, false, false));
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_DOT.get()), x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y, z + 1), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x + 1, y + 1, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x - 1, y + 1, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y + 1, z + 1), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y + 1, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x + 1, y + 2, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x - 1, y + 2, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y + 2, z + 1), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.GLASS_PANE || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.GLASS) {
			world.destroyBlock(BlockPos.containing(x, y + 2, z - 1), false);
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer < 14) {
			if (entity instanceof MidnightLurkerAggressiveEntity) {
				((MidnightLurkerAggressiveEntity) entity).setAnimation("teleport1");
			}
		}
		if (entity.getPersistentData().getDouble("LurkerScream") == 0) {
			entity.getPersistentData().putDouble("LurkerScream", 110);
		} else {
			entity.getPersistentData().putDouble("LurkerScream", (entity.getPersistentData().getDouble("LurkerScream") - 1));
		}
		if (entity.getPersistentData().getDouble("LurkerScream") == 1) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 25, 25, 25), e -> true).isEmpty()) {
				MidnightlurkerMod.queueServerWork(1, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerscream")), SoundSource.NEUTRAL, 50, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerscream")), SoundSource.NEUTRAL, 50, 1, false);
						}
					}
				});
			}
		}
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == false) {
					MidnightlurkerMod.queueServerWork(1210, () -> {
						if (entity instanceof MidnightLurkerAggressiveEntity) {
							((MidnightLurkerAggressiveEntity) entity).setAnimation("teleport1");
						}
						if (entity instanceof MidnightlurkerNEEntity) {
							((MidnightlurkerNEEntity) entity).setAnimation("teleport1");
						}
						MidnightlurkerMod.queueServerWork(13, () -> {
							if (!entity.level.isClientSide())
								entity.discard();
						});
					});
				} else if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == true) {
					MidnightlurkerMod.queueServerWork(2410, () -> {
						if (entity instanceof MidnightLurkerAggressiveEntity) {
							((MidnightLurkerAggressiveEntity) entity).setAnimation("teleport1");
						}
						if (entity instanceof MidnightlurkerNEEntity) {
							((MidnightlurkerNEEntity) entity).setAnimation("teleport1");
						}
						MidnightlurkerMod.queueServerWork(13, () -> {
							if (!entity.level.isClientSide())
								entity.discard();
						});
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
