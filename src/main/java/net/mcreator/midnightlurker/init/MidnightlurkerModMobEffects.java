
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.potion.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MidnightlurkerModMobEffects {
	public static final StatusEffect INSANITY = Registry.register(Registries.STATUS_EFFECT, "midnightlurker:insanity", new InsanityMobEffect());
	public static final StatusEffect INSANITY_FACES = Registry.register(Registries.STATUS_EFFECT, "midnightlurker:insanity_faces", new InsanityFacesMobEffect());
	public static final StatusEffect LURKER_ANGERED = Registry.register(Registries.STATUS_EFFECT, "midnightlurker:lurker_angered", new LurkerAngeredMobEffect());
	public static final StatusEffect AMNESIA = Registry.register(Registries.STATUS_EFFECT, "midnightlurker:amnesia", new AmnesiaMobEffect());
	public static final StatusEffect STATIC_EFFECT = Registry.register(Registries.STATUS_EFFECT, "midnightlurker:static_effect", new StaticEffectMobEffect());

	public static void init() {}

}
