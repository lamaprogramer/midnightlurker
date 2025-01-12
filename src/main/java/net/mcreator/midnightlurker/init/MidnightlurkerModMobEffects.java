
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.potion.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class MidnightlurkerModMobEffects {
	public static final RegistryEntry<StatusEffect> INSANITY = register("midnightlurker:insanity", new InsanityMobEffect());
	public static final RegistryEntry<StatusEffect> INSANITY_FACES = register("midnightlurker:insanity_faces", new InsanityFacesMobEffect());
	public static final RegistryEntry<StatusEffect> LURKER_ANGERED = register("midnightlurker:lurker_angered", new LurkerAngeredMobEffect());
	public static final RegistryEntry<StatusEffect> AMNESIA = register("midnightlurker:amnesia", new AmnesiaMobEffect());
	public static final RegistryEntry<StatusEffect> STATIC_EFFECT = register("midnightlurker:static_effect", new StaticEffectMobEffect());

	public static void init() {}

	private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(id), statusEffect);
	}

}
