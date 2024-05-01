
package net.mcreator.midnightlurker.potion;

import net.mcreator.midnightlurker.procedures.AmnesiaOnEffectActiveTickProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AmnesiaMobEffect extends StatusEffect {
	public AmnesiaMobEffect() {
		super(StatusEffectCategory.HARMFUL, -12708839);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.amnesia";
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		AmnesiaOnEffectActiveTickProcedure.execute(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
