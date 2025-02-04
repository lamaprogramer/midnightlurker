
package net.mcreator.midnightlurker.potion;

import net.mcreator.midnightlurker.util.BlockUtil;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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
		World world = entity.getWorld();

		double raytrace_distance = 0;
		boolean entity_found = false;
		for (int index0 = 0; index0 < 30; index0++) {
			BlockHitResult blockHit = BlockUtil.raycast(entity, raytrace_distance);
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, new Vec3d((blockHit.getBlockPos().getX()), (blockHit.getBlockPos().getY()), (blockHit.getBlockPos().getZ())), 25) && !(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == entity)) {
				entity_found = true;
			} else {
				entity_found = false;
				raytrace_distance++;
			}
		}

		if (entity_found) {
			BlockHitResult blockHit = BlockUtil.raycast(entity, raytrace_distance);
			if (!(EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, blockHit.getBlockPos(), 25) == null)) {
				SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
			}
		} else {
			if (EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, entity.getPos(), 10)) {
				if (!EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, entity.getPos(), 30)) {
					if (!EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, entity.getPos(), 30, 30, 30).getWorld().isClient()) {
						EntityUtil.getEntityWithMinDistanceOf(HostileEntity.class, world, entity.getPos(), 30, 30, 30).discard();
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
