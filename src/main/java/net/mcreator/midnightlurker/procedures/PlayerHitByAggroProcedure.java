package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;


public class PlayerHitByAggroProcedure {
	public static void execute(DamageSource damageSource, WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (entity instanceof PlayerEntity) {
			if (damageSource.getAttacker() instanceof MidnightLurkerAggressiveEntity) {
				for (int index0 = 0; index0 < 50; index0++) {
					double posX = x + MathHelper.nextDouble(Random.create(), -6, 6);
					double posY = y + MathHelper.nextDouble(Random.create(), 0, 6);
					double posZ = z + MathHelper.nextDouble(Random.create(), -6, 6);
					System.out.println(posX + " " + posY + " " + posZ);
					world.addParticle(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE,
							posX,
							posY,
							posZ,
							0, 0, 0);
				}
			}
		}
	}
}
