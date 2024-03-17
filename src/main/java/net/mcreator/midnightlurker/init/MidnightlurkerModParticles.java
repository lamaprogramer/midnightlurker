
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.mcreator.midnightlurker.client.particle.LurkerfaceparticleParticle;
import net.mcreator.midnightlurker.client.particle.VoidDotParticle;
import net.mcreator.midnightlurker.client.particle.VoidGatewayParticleParticle;

public class MidnightlurkerModParticles {
	public static void init() {
		ParticleFactoryRegistry.getInstance().register(
				MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE,
				VoidGatewayParticleParticle.VoidGatewayParticleFactory::new
		);
		ParticleFactoryRegistry.getInstance().register(
				MidnightlurkerModParticleTypes.VOID_DOT,
				VoidDotParticle.VoidDotParticleFactory::new
		);
		ParticleFactoryRegistry.getInstance().register(
				MidnightlurkerModParticleTypes.LURKERFACEPARTICLE,
				LurkerfaceparticleParticle.LurkerfaceparticleParticleFactory::new
		);
	}
}
