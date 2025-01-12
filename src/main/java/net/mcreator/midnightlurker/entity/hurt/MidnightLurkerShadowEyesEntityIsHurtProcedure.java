package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerShadowEyesEntityIsHurtProcedure {

	public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerShadowEyesEntity);
    }
}
