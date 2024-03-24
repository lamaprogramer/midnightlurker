package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.minecraft.entity.Entity;

public class Destroytex3EntityIsHurtProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return true;
        return !(entity instanceof Destroytex3Entity);
    }
}
