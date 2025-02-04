
package net.mcreator.midnightlurker.potion;


import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

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
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		
		if (entityData.getPersistentData().getDouble("StaticRender") == 0) {
			double _setval = MathHelper.nextInt(Random.create(), 20, 45);
			entityData.getPersistentData().putDouble("StaticRender", _setval);
		}

		if (entityData.getPersistentData().getDouble("StaticRender") > 0) {
			double _setval = entityData.getPersistentData().getDouble("StaticRender") - 1;
			entityData.getPersistentData().putDouble("StaticRender", _setval);
		}

		if (entityData.getPersistentData().getDouble("StaticRender") == 10) {
			if (entity.getWorld() instanceof ServerWorld level) {
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:static record @p ~ ~ ~ 1 1");
			}
		}

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
