package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class AggroPotionAddTickProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		//IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 7) {
			if (world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
				if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
					_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.LURKER_ANGERED, 2, 0, false, false));
			}
		}
	}
}
