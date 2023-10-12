
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MidnightlurkerMod.MODID);
	public static final RegistryObject<SoundEvent> LURKERJUMPSCARE = REGISTRY.register("lurkerjumpscare", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("midnightlurker", "lurkerjumpscare")));
	public static final RegistryObject<SoundEvent> LURKERANGER = REGISTRY.register("lurkeranger", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("midnightlurker", "lurkeranger")));
	public static final RegistryObject<SoundEvent> LURKERDISAPPEAR = REGISTRY.register("lurkerdisappear", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("midnightlurker", "lurkerdisappear")));
	public static final RegistryObject<SoundEvent> LURKERCHASE = REGISTRY.register("lurkerchase", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("midnightlurker", "lurkerchase")));
}
