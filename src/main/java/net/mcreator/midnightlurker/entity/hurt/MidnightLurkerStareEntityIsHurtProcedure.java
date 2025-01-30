package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;


public class MidnightLurkerStareEntityIsHurtProcedure {

	public static boolean execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return true;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		CoreConfig config = MidnightlurkerMod.CONFIG;
		
		if (entity instanceof MidnightLurkerStareEntity && sourceentity instanceof PlayerEntity) {
			entityData.getPersistentData().putDouble("StareCountdown", 400);
		}

		if (config.isLurkerInvulnerable()) {
            return !(entity instanceof MidnightLurkerStareEntity) || !(sourceentity instanceof PlayerEntity);
		} else{
			if (entity instanceof MidnightLurkerStareEntity && sourceentity instanceof PlayerEntity) {
				if (entityData.getPersistentData().getBoolean("Stunned")) {
					entityData.getPersistentData().putBoolean("Stunned", true);
				}
                return !(entityData.getPersistentData().getDouble("StunTimer") > 0);
			}
		}

		return true;
	}
}
