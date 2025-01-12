package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerFakerOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") <= 0 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(),entity.getZ()), 25)) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("PlayerActivation", (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanePotionTimer") == 1) {
			if (entity instanceof MidnightLurkerFakerEntity) {
                LivingEntity _livEnt9 = (LivingEntity) entity;
                if (!_livEnt9.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
                    ((MidnightLurkerFakerEntity) entity).setAnimation("snapstare4");
                    LivingEntity _entity = (LivingEntity) entity;
                    if (!_entity.getWorld().isClient())
                        _entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 80, 0, false, false));
                }
            }
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") >= 1) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanePotionTimer") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanePotionTimer", (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanePotionTimer") + 1));
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") < 1 && ((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") >= 1
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 1
				&& entity instanceof LivingEntity _livEnt19 && _livEnt19.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("SlownessEffect", (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") + 1));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") <= 0 && !(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY))
				&& ((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") <= 0) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("SlownessEffect", 0);
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") <= 0) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 255, false, false));
		}
		if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 0, false, false));
		if (entity.hasVehicle()) {
			entity.stopRiding();
		}
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			if (!entity.getWorld().isClient())
				entity.discard();

			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
				{
					double _setval = 1;
					dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
				}
			}
			if (dataSaver.getPersistentData().getDouble("InsanityStage") < 7) {
				{
					double _setval = dataSaver.getPersistentData().getDouble("InsanityStage") + 1;
					dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
				}
				{
					double _setval = 0;
					dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
				}
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") >= 1 && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 30)
				&& ((IEntityDataSaver)entity).getPersistentData().getDouble("PlayerActivation") >= 1) {
			if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 30, 30, 30) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") <= 0 && entity instanceof LivingEntity _livEnt72 && _livEnt72.hasStatusEffect(StatusEffects.SLOWNESS)) {
			entity.setSneaking(true);
		} else if (((IEntityDataSaver)entity).getPersistentData().getDouble("SlownessEffect") >= 1 && entity instanceof LivingEntity _livEnt75 && _livEnt75.hasStatusEffect(StatusEffects.SLOWNESS)) {
			MidnightlurkerMod.queueServerWork(2, () -> {
				entity.setSneaking(false);
			});
		}

		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleClimbing(world, entity, x ,y ,z);

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 80)) {
			if (EntityUtil.getEntityWithRaycast(entity, entity, 80) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 80, 80, 80)) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") < 300) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("CaveSoundLurk", (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") + 1));
				}
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("CaveSoundLurk") == 299) {
					if (world instanceof ServerWorld level)
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
								"/playsound minecraft:ambient.cave ambient @a ~ ~ ~ 80 0.6");
				}
			}
		}
	}
}
