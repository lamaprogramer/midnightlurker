
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MidnightlurkerModParticleTypes {
	public static final SimpleParticleType VOID_GATEWAY_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType VOID_DOT = FabricParticleTypes.simple();
	public static final SimpleParticleType LURKERFACEPARTICLE = FabricParticleTypes.simple();

	public static void init() {
		register(Identifier.of(MidnightlurkerMod.MODID, "void_gateway_particle"), VOID_GATEWAY_PARTICLE);
		register(Identifier.of(MidnightlurkerMod.MODID, "void_dot"), VOID_DOT);
		register(Identifier.of(MidnightlurkerMod.MODID, "lurkerfaceparticle"), LURKERFACEPARTICLE);
	}
	private static void register(Identifier id, SimpleParticleType particleType) {
		Registry.register(Registries.PARTICLE_TYPE, id, particleType);
	}
}
