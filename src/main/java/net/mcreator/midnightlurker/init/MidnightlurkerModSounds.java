
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;


import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MidnightlurkerModSounds {
	public static final Identifier LURKERANGER = Identifier.of("midnightlurker", "lurkeranger");
	public static final Identifier LURKERDISAPPEAR = Identifier.of("midnightlurker", "lurkerdisappear");
	public static final Identifier LURKERCHASE = Identifier.of("midnightlurker", "lurkerchase");
	public static final Identifier LURKERINVISIBLEJUMPSCARE = Identifier.of("midnightlurker", "lurkerinvisiblejumpscare");
	public static final Identifier LURKERCHASE2 = Identifier.of("midnightlurker", "lurkerchase2");
	public static final Identifier LURKERPREFINALBREAK = Identifier.of("midnightlurker", "lurkerprefinalbreak");
	public static final Identifier LURKERFINALBREAK = Identifier.of("midnightlurker", "lurkerfinalbreak");
	public static final Identifier SPOOKYAMBIENCE = Identifier.of("midnightlurker", "spookyambience");
	public static final Identifier INSANITYGOESBACKSOUND = Identifier.of("midnightlurker", "insanitygoesbacksound");
	public static final Identifier INSANITYAMBIENCE = Identifier.of("midnightlurker", "insanityambience");
	public static final Identifier INSANITYCHASE = Identifier.of("midnightlurker", "insanitychase");
	public static final Identifier LURKERBREAKINGBLOCK = Identifier.of("midnightlurker", "lurkerbreakingblock");
	public static final Identifier LURKERDISTANTSCREAM = Identifier.of("midnightlurker", "lurkerdistantscream");
	public static final Identifier LURKERDEATH = Identifier.of("midnightlurker", "lurkerdeath");
	public static final Identifier LURKERDEATHJUMPSCARE = Identifier.of("midnightlurker", "lurkerdeathjumpscare");
	public static final Identifier LURKERSCREAM = Identifier.of("midnightlurker", "lurkerscream");
	public static final Identifier LURKERAMBIENT = Identifier.of("midnightlurker", "lurkerambient");
	public static final Identifier LURKERCHASESTEPS = Identifier.of("midnightlurker", "lurkerchasesteps");
	public static final Identifier LURKERJUMPSCARE = Identifier.of("midnightlurker", "lurkerjumpscare");
	public static final Identifier LURKERHURT = Identifier.of("midnightlurker", "lurkerhurt");
	public static final Identifier NOSTEPSOUND = Identifier.of("midnightlurker", "nostepsound");
	public static final Identifier VOIDHANDS_AGGRO = Identifier.of("midnightlurker", "voidhands_aggro");
	public static final Identifier VOIDHANDS_DEATH = Identifier.of("midnightlurker", "voidhands_death");
	public static final Identifier VOIDHANDS_HURT = Identifier.of("midnightlurker", "voidhands_hurt");
	public static final Identifier VOIDHANDS_SHRIEK = Identifier.of("midnightlurker", "voidhands_shriek");
	public static final Identifier STATIC = Identifier.of("midnightlurker", "static");
	public static final Identifier PHANTOM_HEAD_SCREAM = Identifier.of("midnightlurker", "phantom_head_scream");
	public static final Identifier LURKERFOOTSTEPS = Identifier.of("midnightlurker", "lurkerfootsteps");
	public static final Identifier THIRTEEN_AMBIENT = Identifier.of("midnightlurker", "thirteen_ambient");
	public static final Identifier LURKER_STUNNED = Identifier.of("midnightlurker", "lurker_stunned");
	public static final Identifier LURKER_TAUNT = Identifier.of("midnightlurker", "lurker_taunt");
	public static final Identifier LURKER_STUN_OVER = Identifier.of("midnightlurker", "lurker_stun_over");
	
	public static void init() {
		register(LURKERANGER, SoundEvent.of(LURKERANGER));
		register(LURKERDISAPPEAR, SoundEvent.of(LURKERDISAPPEAR));
		register(LURKERCHASE, SoundEvent.of(LURKERCHASE));
		register(LURKERINVISIBLEJUMPSCARE, SoundEvent.of(LURKERINVISIBLEJUMPSCARE));
		register(LURKERCHASE2, SoundEvent.of(LURKERCHASE2));
		register(LURKERPREFINALBREAK, SoundEvent.of(LURKERPREFINALBREAK));
		register(LURKERFINALBREAK, SoundEvent.of(LURKERFINALBREAK));
		register(SPOOKYAMBIENCE, SoundEvent.of(SPOOKYAMBIENCE));
		register(INSANITYGOESBACKSOUND, SoundEvent.of(INSANITYGOESBACKSOUND));
		register(INSANITYAMBIENCE, SoundEvent.of(INSANITYAMBIENCE));
		register(INSANITYCHASE, SoundEvent.of(INSANITYCHASE));
		register(LURKERBREAKINGBLOCK, SoundEvent.of(LURKERBREAKINGBLOCK));
		register(LURKERDISTANTSCREAM, SoundEvent.of(LURKERDISTANTSCREAM));
		register(LURKERDEATH, SoundEvent.of(LURKERDEATH));
		register(LURKERDEATHJUMPSCARE, SoundEvent.of(LURKERDEATHJUMPSCARE));
		register(LURKERSCREAM, SoundEvent.of(LURKERSCREAM));
		register(LURKERAMBIENT, SoundEvent.of(LURKERAMBIENT));
		register(LURKERCHASESTEPS, SoundEvent.of(LURKERCHASESTEPS));
		register(LURKERJUMPSCARE, SoundEvent.of(LURKERJUMPSCARE));
		register(LURKERHURT, SoundEvent.of(LURKERHURT));
		register(NOSTEPSOUND, SoundEvent.of(NOSTEPSOUND));
		register(VOIDHANDS_AGGRO, SoundEvent.of(VOIDHANDS_AGGRO));
		register(VOIDHANDS_DEATH, SoundEvent.of(VOIDHANDS_DEATH));
		register(VOIDHANDS_HURT, SoundEvent.of(VOIDHANDS_HURT));
		register(VOIDHANDS_SHRIEK, SoundEvent.of(VOIDHANDS_SHRIEK));
		register(STATIC, SoundEvent.of(STATIC));
		register(PHANTOM_HEAD_SCREAM, SoundEvent.of(PHANTOM_HEAD_SCREAM));
		register(LURKERFOOTSTEPS, SoundEvent.of(LURKERFOOTSTEPS));
		register(THIRTEEN_AMBIENT, SoundEvent.of(THIRTEEN_AMBIENT));
		register(LURKER_STUNNED, SoundEvent.of(LURKER_STUNNED));
		register(LURKER_TAUNT, SoundEvent.of(LURKER_TAUNT));
		register(LURKER_STUN_OVER, SoundEvent.of(LURKER_STUN_OVER));
	}
	private static void register(Identifier id, SoundEvent event) {
		Registry.register(Registries.SOUND_EVENT, id, event);
	}
}
