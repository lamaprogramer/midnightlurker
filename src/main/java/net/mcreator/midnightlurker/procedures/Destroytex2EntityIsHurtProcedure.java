package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.minecraft.entity.Entity;


public class Destroytex2EntityIsHurtProcedure {
	public static boolean execute(Entity entity) {
        if (entity == null)
            return true;
        return !(entity instanceof Destroytex2Entity);
    }
}
