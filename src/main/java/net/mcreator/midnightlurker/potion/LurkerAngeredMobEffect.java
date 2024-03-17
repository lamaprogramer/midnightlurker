
package net.mcreator.midnightlurker.potion;



import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffect;


import net.mcreator.midnightlurker.procedures.AggroSpawnProcedure;

public class LurkerAngeredMobEffect extends StatusEffect {
	public LurkerAngeredMobEffect() {
		super(StatusEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getTranslationKey() {
		return "effect.midnightlurker.lurker_angered";
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		AggroSpawnProcedure.execute(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	
}
