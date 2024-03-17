package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DestroytexOnEntityTickUpdateProcedure {
	public static <Entity extends net.minecraft.entity.Entity> void execute(World world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MidnightlurkerMod.queueServerWork(20, () -> {
			if (!world.getEntitiesByClass(DestroytexEntity.class, Box.of(new Vec3d(x, y, z), 4, 4, 4), e -> true).isEmpty()
					|| !world.getEntitiesByClass(Destroytex2Entity.class, Box.of(new Vec3d(x, y, z), 4, 4, 4), e -> true).isEmpty()
					|| !world.getEntitiesByClass(Destroytex3Entity.class, Box.of(new Vec3d(x, y, z), 4, 4, 4), e -> true).isEmpty()
					|| !world.getEntitiesByClass(Destroytex4Entity.class, Box.of(new Vec3d(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				if (!entity.getEntityWorld().isClient())
					entity.discard();
			}
		});
	}
}
