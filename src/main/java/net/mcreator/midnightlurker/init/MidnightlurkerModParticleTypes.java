
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModParticleTypes {
	public static final DefaultParticleType VOID_GATEWAY_PARTICLE = FabricParticleTypes.simple();
	public static final DefaultParticleType VOID_DOT = FabricParticleTypes.simple();
	public static final DefaultParticleType LURKERFACEPARTICLE = FabricParticleTypes.simple();

	public static void init() {
		register(new Identifier(MidnightlurkerMod.MODID, "void_gateway_particle"), VOID_GATEWAY_PARTICLE);
		register(new Identifier(MidnightlurkerMod.MODID, "void_dot"), VOID_DOT);
		register(new Identifier(MidnightlurkerMod.MODID, "lurkerfaceparticle"), LURKERFACEPARTICLE);
	}
	private static void register(Identifier id, DefaultParticleType particleType) {
		Registry.register(Registries.PARTICLE_TYPE, id, particleType);
	}
}
