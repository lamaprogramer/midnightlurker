
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.midnightlurker.potion.InsanityMobEffect;
import net.mcreator.midnightlurker.potion.InsanityFacesMobEffect;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MidnightlurkerMod.MODID);
	public static final RegistryObject<MobEffect> INSANITY = REGISTRY.register("insanity", () -> new InsanityMobEffect());
	public static final RegistryObject<MobEffect> INSANITY_FACES = REGISTRY.register("insanity_faces", () -> new InsanityFacesMobEffect());
}
