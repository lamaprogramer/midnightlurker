package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class SetinsanitycommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PlayerEntity) {
			{
				double _setval = 0;
				((IEntityDataSaver)entity).getPersistentData().putDouble("InsanityStage", _setval);
			}
		}
	}
}
