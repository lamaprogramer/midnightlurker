package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerShadowEntityIsHurtProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerShadowEntity);
    }
}
