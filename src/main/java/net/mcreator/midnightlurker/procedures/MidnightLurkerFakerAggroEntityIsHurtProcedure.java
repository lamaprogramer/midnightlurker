package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.minecraft.entity.Entity;


public class MidnightLurkerFakerAggroEntityIsHurtProcedure {

    public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof MidnightLurkerFakerAggroEntity);
    }
}
