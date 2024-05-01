
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.procedures.InsanityFacesEffectStartedappliedProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class InsanityFacesMobEffect extends StatusEffect {
	public InsanityFacesMobEffect() {
		super(StatusEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.insanity_faces";
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		InsanityFacesEffectStartedappliedProcedure.execute(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ());
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
