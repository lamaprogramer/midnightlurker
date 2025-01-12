package net.mcreator.midnightlurker.entity.spawnconditions.init;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

public class MidnightPhantomHeadOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;

		((IEntityDataSaver)entity).getPersistentData().putDouble("InvisNumb", (MathHelper.nextInt(Random.create(), 0, 1)));
		((IEntityDataSaver)entity).getPersistentData().putDouble("AttackOnSight", (MathHelper.nextInt(Random.create(), 0, 100)));
	}
}
