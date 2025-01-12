package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerEntityDiesProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive > 0) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300);
		if (dataSaver.getPersistentData().getDouble("InsanityAktive") > 0) {
			{
				double _setval = 0;
				dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
			}
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost < 5) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost + 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
