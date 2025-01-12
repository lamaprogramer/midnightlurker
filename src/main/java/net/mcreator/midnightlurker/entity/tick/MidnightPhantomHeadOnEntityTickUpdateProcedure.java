package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.MidnightPhantomHeadEntity;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

import java.util.Comparator;
import java.util.List;

public class MidnightPhantomHeadOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yaw = 0;
		if ((world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 33, 33, 33), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead01");
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 32, 32, 32), e -> true).isEmpty() && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 29, 29, 29), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead02");
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 28, 28, 28), e -> true).isEmpty() && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 25, 25, 25), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead03");
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 24, 24, 24), e -> true).isEmpty() && (EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20))) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead1");
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 19, 19, 19), e -> true).isEmpty() && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 18, 18, 18), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead2");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 19, 19, 19)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 0.1 0.2");
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 17, 17, 17), e -> true).isEmpty() && (EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15))) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead3");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 17, 17, 17)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 0.3 0.2");
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 14, 14, 14), e -> true).isEmpty() && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 12, 12, 12), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead4");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 14, 14, 14)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 0.5 0.2");
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 11, 11, 11), e -> true).isEmpty() && (EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8))) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead5");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 11, 11, 11)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 0.7 0.2");
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 7, 7, 7), e -> true).isEmpty() && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead6");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 7, 7, 7)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 0.8 0.2");
			}
		} else if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			if (entity instanceof MidnightPhantomHeadEntity animatable)
				animatable.setTexture("midnightlurkerphantomhead7");
			if ((entity instanceof MobEntity _mobEnt ? (Entity) _mobEnt.getTarget() : null) == EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 4, 4, 4)) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
							"/playsound midnightlurker:phantom_head_scream neutral @a ~ ~ ~ 1 0.2");
			}
		}

		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
			if (EntityUtil.getEntityWithRaycast(EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 40, 40, 40), entity, 40) instanceof MidnightPhantomHeadEntity) {
				if (((IEntityDataSaver)entity).getPersistentData().getDouble("lookingatphantomhead") < 2000) {
					((IEntityDataSaver)entity).getPersistentData().putDouble("lookingatphantomhead", 2000);
				}
			}
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("lookingatphantomhead") > 0) {
			((IEntityDataSaver)entity).getPersistentData().putDouble("lookingatphantomhead", (((IEntityDataSaver)entity).getPersistentData().getDouble("lookingatphantomhead") - 1));
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 20)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("despawntimephant") < 600) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("despawntimephant", (((IEntityDataSaver)entity).getPersistentData().getDouble("despawntimephant") + 1));
			}
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("despawntimephant") >= 600) {
				if (!entity.getWorld().isClient())
					entity.discard();
			}
			if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 255, false, false));
			if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 5, 200, false, false));
			{
				final Vec3d _center = new Vec3d(x, y, z);
				List<Entity> _entfound = world.getEntitiesByClass(Entity.class, new Box(_center, _center).expand(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.squaredDistanceTo(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						yaw = entity.getYaw() - Math.atan2(entity.getX() - entityiterator.getX(), entity.getZ() - entityiterator.getZ()) / 57.5 + 180.5;
					}
					{
						Entity _ent = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 20, 20, 20);
						_ent.setYaw((float) yaw);
						_ent.setPitch(0);
						_ent.setBodyYaw(_ent.getYaw());
						_ent.setHeadYaw(_ent.getYaw());
						_ent.prevYaw = _ent.getYaw();
						_ent.prevPitch = _ent.getPitch();
                        LivingEntity _entity = (LivingEntity) _ent;
                        _entity.prevBodyYaw = _entity.getYaw();
                        _entity.prevHeadYaw = _entity.getYaw();
                    }
				}
			}
		}

		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 24, 24, 24), e -> true).isEmpty() && !(entity instanceof LivingEntity _livEnt81 && _livEnt81.hasStatusEffect(StatusEffects.INVISIBILITY))) {
			EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.2, 0.2, 0.2, 0.1);
		}

		if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 11, 11, 11), e -> true).isEmpty()) {
			if (entity instanceof MidnightPhantomHeadEntity) {
				((MidnightPhantomHeadEntity) entity).setAnimation("animation.midnightlurkerphantomhead.close");
			}
		} else if ((world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 11, 11, 11), e -> true).isEmpty())) {
			if (entity instanceof MidnightPhantomHeadEntity) {
				((MidnightPhantomHeadEntity) entity).setAnimation("empty");
			}
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("lookingatphantomhead") == 0) {
			entity.setVelocity(new Vec3d(0, (entity.getVelocity().getY()), 0));
		}

		if (((IEntityDataSaver)entity).getPersistentData().getDouble("InvisNumb") == 1 && (world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d(x, y, z), 24, 24, 24), e -> true).isEmpty())) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("lookingatphantomhead") < 3) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("lookingatphantomhead", 3);
			}
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 3, 0, false, false));
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
			if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") < 2) {
				((IEntityDataSaver)entity).getPersistentData().putDouble("encount", (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") + 1));
			}
		}

		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 8, 8, 8);
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("encount") == 1) {
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 8)) {
				if (dataSaver.getPersistentData().getDouble("encounternumber") < 6) {
					{
						double _setval = dataSaver.getPersistentData().getDouble("encounternumber") + 1;
						dataSaver.getPersistentData().putDouble("encounternumber", _setval);
					}
				}
			}
		}
	}
}
