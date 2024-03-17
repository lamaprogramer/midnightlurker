
package net.mcreator.midnightlurker.potion;



import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffect;

import net.mcreator.midnightlurker.procedures.InsanitysoundsProcedure;

public class InsanityMobEffect extends StatusEffect {
	public InsanityMobEffect() {
		super(StatusEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.insanity";
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		InsanitysoundsProcedure.execute(entity.getWorld(), entity);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	
}
