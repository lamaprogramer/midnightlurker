package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.minecraft.entity.Entity;


public class VoidGatewayEntityIsHurtProcedure {

	public static boolean execute(Entity entity) {
		if (entity == null)
			return true;
        return !(entity instanceof VoidGatewayEntity);
    }
}
