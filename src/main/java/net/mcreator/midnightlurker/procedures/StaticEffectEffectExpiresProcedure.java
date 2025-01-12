package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;

public class StaticEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			((IEntityDataSaver)entity).getPersistentData().putDouble("StaticRender", _setval);
		}
	}
}
