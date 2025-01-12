package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerFakerEntityIsHurtProcedure {

    public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerFakerEntity);
    }
}
