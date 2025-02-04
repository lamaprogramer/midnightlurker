
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

public class InsanityMobEffect extends StatusEffect {
	public InsanityMobEffect() {
		super(StatusEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.insanity";
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) {

			if (entityData.getPersistentData().getDouble("InsanitySounds") < 159) {
				entityData.getPersistentData().putDouble("InsanitySounds", (entityData.getPersistentData().getDouble("InsanitySounds") + 1));
			} else if (entityData.getPersistentData().getDouble("InsanitySounds") >= 159) {
				entityData.getPersistentData().putDouble("InsanitySounds", 0);
			}

			if (entityData.getPersistentData().getDouble("InsanitySounds") == 1) {
				if (entityData.getPersistentData().getDouble("InsanityStage") < 7) {
					if (entity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() > 20) {
						if (entity.getWorld() instanceof ServerWorld level) {
							level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:insanityambience neutral @p");
						}
					}
				} else if (entityData.getPersistentData().getDouble("InsanityStage") >= 7) {
					if (entity.getStatusEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() > 20) {
						if (entity.getWorld() instanceof ServerWorld level) {
							level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:insanitychase neutral @p");
						}
					}
				}
			}
		}

		if (!(entity.hasStatusEffect(MidnightlurkerModMobEffects.INSANITY)) && entityData.getPersistentData().getDouble("InsanitySounds") > 0) {
			entityData.getPersistentData().putDouble("InsanitySounds", 0);
		}
		return true;
	}

	@Override
	public int getFadeTicks() {
		return 20;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	
}
