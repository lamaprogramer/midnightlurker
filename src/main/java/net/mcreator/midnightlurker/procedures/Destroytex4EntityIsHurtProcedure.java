package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.minecraft.entity.Entity;

public class Destroytex4EntityIsHurtProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return true;
        return !(entity instanceof Destroytex4Entity);
    }
}
