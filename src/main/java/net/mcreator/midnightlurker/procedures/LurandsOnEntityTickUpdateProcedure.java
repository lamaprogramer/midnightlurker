package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class LurandsOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") <= 0 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 10) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("PlayerActivationGateway", (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivationGateway") >= 1) {
			if (entity instanceof VoidHandsEntity) {
				((VoidHandsEntity) entity).setAnimation("animation.lurands.disappear");
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("CloseTime") >= 9) {
			if (!entity.getWorld().isClient())
				entity.discard();
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
			MidnightlurkerMod.queueServerWork(10, () -> {
				if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
					IEntityDataSaver minDistanceDataSaver = ((IEntityDataSaver)EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					if (minDistanceDataSaver.getPersistentData().getDouble("encounternumber") < 6) {
						double _setval = minDistanceDataSaver.getPersistentData().getDouble("encounternumber") + 1;
						minDistanceDataSaver.getPersistentData().putDouble("encounternumber", _setval);
						minDistanceDataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8));
					}
				}
				if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
					if (Math.random() > 0.7) {
						IEntityDataSaver minDistanceDataSaver = ((IEntityDataSaver)EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 100, 100, 100));
						if (minDistanceDataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
							double _setval = 1;
							minDistanceDataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
							minDistanceDataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 100, 100, 100));
						}
					}
				}
			});
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE, x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Faking") == 0) {
			entity.setSneaking(true);
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("Faking") == 1) {
			entity.setSneaking(false);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty() && ((IEntityDataSaver)entity).getPersistentData().getDouble("Faking") == 0) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("Faking", 1);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("Reveal") < 3) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("Reveal", (((IEntityDataSaver)entity).getPersistentData().getDouble("Reveal") + 1));
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 65, 65, 65), e -> true).isEmpty()) {
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 65, 65, 65)) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("AggroSounds") < 50) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("AggroSounds", (((IEntityDataSaver)entity).getPersistentData().getDouble("AggroSounds") + 1));
				}
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("AggroSounds") >= 50) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("AggroSounds", 0);
			if (world instanceof ServerWorld _level)
				_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
						"/playsound midnightlurker:voidhands_aggro hostile @a ~ ~ ~ 1 1");
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("Reveal") == 1) {
			if (entity instanceof VoidHandsEntity) {
				((VoidHandsEntity) entity).setAnimation("animation.lurands.reveal");
			}
			if (world instanceof ServerWorld _level)
				_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
						"/playsound midnightlurker:voidhands_shriek hostile @a ~ ~ ~ 1 1");
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 60, 255, false, false));
		if ((world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			if (((world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _getbp74
					&& (world.getBlockState(BlockPos.ofFloored(x + 1, y, z))).get(_getbp74))) {
				{
					BlockPos _pos = BlockPos.ofFloored(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlockState(_pos, _bs.with(_booleanProp, true), 3);
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((x + 1), y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			if (((world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _getbp80
					&& (world.getBlockState(BlockPos.ofFloored(x - 1, y, z))).get(_getbp80))) {
				{
					BlockPos _pos = BlockPos.ofFloored(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlockState(_pos, _bs.with(_booleanProp, true), 3);
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((x - 1), y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			if (((world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _getbp86
					&& (world.getBlockState(BlockPos.ofFloored(x, y, z + 1))).get(_getbp86))) {
				{
					BlockPos _pos = BlockPos.ofFloored(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlockState(_pos, _bs.with(_booleanProp, true), 3);
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, (z + 1)), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		} else if ((world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("midnightlurker:lurkerdoors")))) {
			if (((world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _getbp92
					&& (world.getBlockState(BlockPos.ofFloored(x, y, z - 1))).get(_getbp92))) {
				{
					BlockPos _pos = BlockPos.ofFloored(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateManager().getProperty("open") instanceof BooleanProperty _booleanProp)
						world.setBlockState(_pos, _bs.with(_booleanProp, true), 3);
				}
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, (z - 1)), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound minecraft:block.wooden_door.open block @a ~ ~ ~ 1 1");
			}
		}
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
	}
}
