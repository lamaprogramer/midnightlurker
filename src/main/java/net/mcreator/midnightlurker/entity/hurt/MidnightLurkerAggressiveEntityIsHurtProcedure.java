package net.mcreator.midnightlurker.entity.hurt;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;


public class MidnightLurkerAggressiveEntityIsHurtProcedure {
	public static boolean execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return true;

		CoreConfig config = MidnightlurkerMod.CONFIG;
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		
		if (config.isLurkerInvulnerable()) {

			if ((entity instanceof MidnightLurkerAggressiveEntity || entity instanceof MidnightLurkerBackturnedEntity || entity instanceof MidnightLurkerHiderEntity || entity instanceof MidnightLurkerRuntrueEntity
					|| entity instanceof MidnightLurkerSeenAngressiveEntity || entity instanceof MidnightLurkerStalkingEntity || entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity)
					&& sourceentity instanceof PlayerEntity) {
				return false;
			}
		} else {
			if ((entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity) && sourceentity instanceof PlayerEntity) {
				if (!entityData.getPersistentData().getBoolean("Stunned")) {
					entityData.getPersistentData().putBoolean("Stunned", true);
				}

                return !(entityData.getPersistentData().getDouble("StunTimer") > 0);
			}
		}

		return true;
	}
}
