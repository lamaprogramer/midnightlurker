package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;


public class PlayerHitByAggroProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PlayerEntity) {
			if (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
				for (int index0 = 0; index0 < 50; index0++) {
					world.addParticle(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE, (x + MathHelper.nextDouble(Random.create(), -6, 6)), (y + MathHelper.nextDouble(Random.create(), 0, 6)),
							(z + MathHelper.nextDouble(Random.create(), -6, 6)), 0, 0, 0);
				}
			}
		}
	}
}
