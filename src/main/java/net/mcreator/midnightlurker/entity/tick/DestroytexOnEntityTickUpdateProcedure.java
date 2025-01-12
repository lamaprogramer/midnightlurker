package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DestroytexOnEntityTickUpdateProcedure {
	public static <Entity extends net.minecraft.entity.Entity> void execute(World world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, DestroytexEntity.class, new Vec3d(x, y, z), 4)
				|| !EntityUtil.hasNoEntityOfTypeInArea(world, Destroytex2Entity.class, new Vec3d(x, y, z), 4)
				|| !EntityUtil.hasNoEntityOfTypeInArea(world, Destroytex3Entity.class, new Vec3d(x, y, z), 4)
				|| !EntityUtil.hasNoEntityOfTypeInArea(world, Destroytex4Entity.class, new Vec3d(x, y, z), 4)) {
			if (!entity.getEntityWorld().isClient()) entity.discard();
		}
	}
}
