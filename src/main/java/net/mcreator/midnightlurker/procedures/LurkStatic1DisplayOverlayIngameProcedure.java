package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class LurkStatic1DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.STATIC_EFFECT)
                && (((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 2
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 4
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 6
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 8
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 10);
    }
}
