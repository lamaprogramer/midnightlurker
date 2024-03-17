package net.mcreator.midnightlurker.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

public class StaticEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			((IEntityDataSaver)entity).getPersistentData().putDouble("StaticRender", _setval);
			((IEntityDataSaver)entity).syncPlayerVariables(entity);
		}
	}
}
