package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class Setinsanitystage6Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PlayerEntity) {
			{
				double _setval = 6;
				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityStage", _setval);
				((IEntityDataSaver)entity).syncPlayerVariables(entity);
			}
		}
	}
}
