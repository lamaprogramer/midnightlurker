
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.procedures.InsanitysoundsProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

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
		InsanitysoundsProcedure.execute(entity.getWorld(), entity);
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
