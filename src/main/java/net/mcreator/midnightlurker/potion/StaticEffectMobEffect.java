
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.procedures.StaticEffectOnEffectActiveTickProcedure;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StaticEffectMobEffect extends StatusEffect {
	public StaticEffectMobEffect() {
		super(StatusEffectCategory.HARMFUL, -10066330);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.static_effect";
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		StaticEffectOnEffectActiveTickProcedure.execute(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}

	@Override
	public void onRemoved(AttributeContainer attributeContainer) {
		super.onRemoved(attributeContainer);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
