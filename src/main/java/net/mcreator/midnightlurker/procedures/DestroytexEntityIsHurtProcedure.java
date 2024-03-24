package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.minecraft.entity.Entity;

public class DestroytexEntityIsHurtProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return true;
        return !(entity instanceof DestroytexEntity);
    }
}
