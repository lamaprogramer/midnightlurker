package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerShadowEntityIsHurtProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerShadowEntity);
    }
}
