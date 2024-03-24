package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerFakerEntityIsHurtProcedure {

    public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerFakerEntity);
    }
}
