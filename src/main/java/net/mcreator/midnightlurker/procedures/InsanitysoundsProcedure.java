package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class InsanitysoundsProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") < 159) {
			((IEntityDataSaver) entity).getPersistentData().putDouble("InsanitySounds", (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") + 1));
		} else if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") >= 159) {
			((IEntityDataSaver) entity).getPersistentData().putDouble("InsanitySounds", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") > 0) {
			((IEntityDataSaver) entity).getPersistentData().putDouble("InsanitySounds", 0);
		}
		if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7) {
            if (_livEnt10.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") == 1) {
                LivingEntity _livEnt = (LivingEntity) entity;
                if ((_livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) > 20) {
                    if (world instanceof ServerWorld _level)
                        _level.getServer().getCommandManager().executeWithPrefix(
                                new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
                                "/playsound midnightlurker:insanityambience neutral @p");
                }
            }
		} else if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") >= 7) {
            if (_livEnt18.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanitySounds") == 1) {
                LivingEntity _livEnt = (LivingEntity) entity;
                if ((_livEnt.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) > 20) {
                    if (world instanceof ServerWorld _level)
                        _level.getServer().getCommandManager().executeWithPrefix(
                                new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
                                "/playsound midnightlurker:insanitychase neutral @p");
                }
            }
		}
	}
}
