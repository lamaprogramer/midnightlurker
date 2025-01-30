
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

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
		if (Math.random() > 0.7) {
			entity.getWorld().addParticle(
					MidnightlurkerModParticleTypes.LURKERFACEPARTICLE,
					(entity.getX() + MathHelper.nextDouble(Random.create(), -6, 6)),
					(entity.getY() + MathHelper.nextDouble(Random.create(), 0, 6)),
					(entity.getZ() + MathHelper.nextDouble(Random.create(), -6, 6)),
					0, 0, 0
			);
		}
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
