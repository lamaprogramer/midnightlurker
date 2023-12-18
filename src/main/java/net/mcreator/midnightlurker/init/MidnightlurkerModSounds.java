
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
	public static final RegistryObject<SoundEvent> LURKERANGER = REGISTRY.register("lurkeranger", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkeranger")));
	public static final RegistryObject<SoundEvent> LURKERDISAPPEAR = REGISTRY.register("lurkerdisappear", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerdisappear")));
	public static final RegistryObject<SoundEvent> LURKERCHASE = REGISTRY.register("lurkerchase", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerchase")));
	public static final RegistryObject<SoundEvent> LURKERINVISIBLEJUMPSCARE = REGISTRY.register("lurkerinvisiblejumpscare", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerinvisiblejumpscare")));
	public static final RegistryObject<SoundEvent> LURKERCHASE2 = REGISTRY.register("lurkerchase2", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerchase2")));
	public static final RegistryObject<SoundEvent> LURKERPREFINALBREAK = REGISTRY.register("lurkerprefinalbreak", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerprefinalbreak")));
	public static final RegistryObject<SoundEvent> LURKERFINALBREAK = REGISTRY.register("lurkerfinalbreak", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerfinalbreak")));
	public static final RegistryObject<SoundEvent> SPOOKYAMBIENCE = REGISTRY.register("spookyambience", () -> new SoundEvent(new ResourceLocation("midnightlurker", "spookyambience")));
	public static final RegistryObject<SoundEvent> INSANITYGOESBACKSOUND = REGISTRY.register("insanitygoesbacksound", () -> new SoundEvent(new ResourceLocation("midnightlurker", "insanitygoesbacksound")));
	public static final RegistryObject<SoundEvent> INSANITYAMBIENCE = REGISTRY.register("insanityambience", () -> new SoundEvent(new ResourceLocation("midnightlurker", "insanityambience")));
	public static final RegistryObject<SoundEvent> INSANITYCHASE = REGISTRY.register("insanitychase", () -> new SoundEvent(new ResourceLocation("midnightlurker", "insanitychase")));
	public static final RegistryObject<SoundEvent> LURKERBREAKINGBLOCK = REGISTRY.register("lurkerbreakingblock", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerbreakingblock")));
	public static final RegistryObject<SoundEvent> LURKERDISTANTSCREAM = REGISTRY.register("lurkerdistantscream", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerdistantscream")));
	public static final RegistryObject<SoundEvent> LURKERDEATH = REGISTRY.register("lurkerdeath", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerdeath")));
	public static final RegistryObject<SoundEvent> LURKERDEATHJUMPSCARE = REGISTRY.register("lurkerdeathjumpscare", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerdeathjumpscare")));
	public static final RegistryObject<SoundEvent> LURKERSCREAM = REGISTRY.register("lurkerscream", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerscream")));
	public static final RegistryObject<SoundEvent> LURKERAMBIENT = REGISTRY.register("lurkerambient", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerambient")));
	public static final RegistryObject<SoundEvent> LURKERHURT = REGISTRY.register("lurkerhurt", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerhurt")));
	public static final RegistryObject<SoundEvent> LURKERFOOTSTEPS = REGISTRY.register("lurkerfootsteps", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerfootsteps")));
	public static final RegistryObject<SoundEvent> LURKERCHASESTEPS = REGISTRY.register("lurkerchasesteps", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerchasesteps")));
	public static final RegistryObject<SoundEvent> LURKERJUMPSCARE = REGISTRY.register("lurkerjumpscare", () -> new SoundEvent(new ResourceLocation("midnightlurker", "lurkerjumpscare")));
}
