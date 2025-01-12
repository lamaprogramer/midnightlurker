package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class InsanityFacesEffectStartedappliedProcedure {
	public static void execute(WorldAccess world, double x, double y, double z) {
		if (Math.random() > 0.7) {
			world.addParticle(
					MidnightlurkerModParticleTypes.LURKERFACEPARTICLE,
					(x + MathHelper.nextDouble(Random.create(), -6, 6)),
					(y + MathHelper.nextDouble(Random.create(), 0, 6)),
					(z + MathHelper.nextDouble(Random.create(), -6, 6)),
					0, 0, 0
			);
		}
	}
}
