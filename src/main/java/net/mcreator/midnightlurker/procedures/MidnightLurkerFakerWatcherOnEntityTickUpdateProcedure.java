package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerFakerWatcherOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (!entity.getWorld().isClient())
				entity.discard();

			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
				{
					double _setval = 1;
					dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
					dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
				}
			}
			if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
				{
					double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
					dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
					dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
				}
				{
					double _setval = 0;
					dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
					dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100));
				}
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerWorld _level)
				_level.spawnParticles(MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 18, 18, 18), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 18, 18, 18) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20), entity, 20) instanceof MidnightLurkerFakerWatcherEntity) {
				
				if (!entity.getWorld().isClient())
					entity.discard();
				
				IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20);
				if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
					{
						double _setval = 1;
						dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
						dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20));
					}
				}
				if (Math.random() > 0.5) {
					if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
						{
							double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
							dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
							dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20));
						}
						{
							double _setval = 0;
							dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
							dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20));
						}
					}
				}
			}
		}
		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") < 300) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundLurk", (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld _level)
						_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.6");
				}
			}
		}
	}
}
