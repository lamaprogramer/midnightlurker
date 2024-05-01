package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class LurkStatic2DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
        return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasStatusEffect(MidnightlurkerModMobEffects.STATIC_EFFECT)
                && (((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 1
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 3
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 5
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 7
                || ((IEntityDataSaver) entity).getPersistentData().getDouble("StaticRender") == 9);
    }
}
