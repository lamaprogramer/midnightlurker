package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class InsanitysoundsProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entity instanceof LivingEntity livingEntity) {
			if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanitySounds") < 159) {
				entityData.getPersistentData().putDouble("InsanitySounds", (entityData.getPersistentData().getDouble("InsanitySounds") + 1));
			} else if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanitySounds") >= 159) {
				entityData.getPersistentData().putDouble("InsanitySounds", 0);
			}


			if (!(livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) && entityData.getPersistentData().getDouble("InsanitySounds") > 0) {
				entityData.getPersistentData().putDouble("InsanitySounds", 0);
			}

			if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanityStage") < 7) {
				if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanitySounds") == 1) {
					if ((livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? livingEntity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) > 20) {
						if (world instanceof ServerWorld level) {
							level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:insanityambience neutral @p");
						}
					}
				}
			} else if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanityStage") >= 7) {
				if (livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) && entityData.getPersistentData().getDouble("InsanitySounds") == 1) {
					if ((livingEntity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY) ? livingEntity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) > 20) {
						if (world instanceof ServerWorld level) {
							level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:insanitychase neutral @p");
						}
					}
				}
			}
		}
	}
}
