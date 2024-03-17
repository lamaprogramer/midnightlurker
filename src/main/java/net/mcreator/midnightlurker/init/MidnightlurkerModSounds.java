
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;


import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MidnightlurkerModSounds {
	public static final Identifier LURKERANGER = new Identifier("midnightlurker", "lurkeranger");
	public static final Identifier LURKERDISAPPEAR = new Identifier("midnightlurker", "lurkerdisappear");
	public static final Identifier LURKERCHASE = new Identifier("midnightlurker", "lurkerchase");
	public static final Identifier LURKERINVISIBLEJUMPSCARE = new Identifier("midnightlurker", "lurkerinvisiblejumpscare");
	public static final Identifier LURKERCHASE2 = new Identifier("midnightlurker", "lurkerchase2");
	public static final Identifier LURKERPREFINALBREAK = new Identifier("midnightlurker", "lurkerprefinalbreak");
	public static final Identifier LURKERFINALBREAK = new Identifier("midnightlurker", "lurkerfinalbreak");
	public static final Identifier SPOOKYAMBIENCE = new Identifier("midnightlurker", "spookyambience");
	public static final Identifier INSANITYGOESBACKSOUND = new Identifier("midnightlurker", "insanitygoesbacksound");
	public static final Identifier INSANITYAMBIENCE = new Identifier("midnightlurker", "insanityambience");
	public static final Identifier INSANITYCHASE = new Identifier("midnightlurker", "insanitychase");
	public static final Identifier LURKERBREAKINGBLOCK = new Identifier("midnightlurker", "lurkerbreakingblock");
	public static final Identifier LURKERDISTANTSCREAM = new Identifier("midnightlurker", "lurkerdistantscream");
	public static final Identifier LURKERDEATH = new Identifier("midnightlurker", "lurkerdeath");
	public static final Identifier LURKERDEATHJUMPSCARE = new Identifier("midnightlurker", "lurkerdeathjumpscare");
	public static final Identifier LURKERSCREAM = new Identifier("midnightlurker", "lurkerscream");
	public static final Identifier LURKERAMBIENT = new Identifier("midnightlurker", "lurkerambient");
	public static final Identifier LURKERCHASESTEPS = new Identifier("midnightlurker", "lurkerchasesteps");
	public static final Identifier LURKERJUMPSCARE = new Identifier("midnightlurker", "lurkerjumpscare");
	public static final Identifier LURKERHURT = new Identifier("midnightlurker", "lurkerhurt");
	public static final Identifier NOSTEPSOUND = new Identifier("midnightlurker", "nostepsound");
	public static final Identifier VOIDHANDS_AGGRO = new Identifier("midnightlurker", "voidhands_aggro");
	public static final Identifier VOIDHANDS_DEATH = new Identifier("midnightlurker", "voidhands_death");
	public static final Identifier VOIDHANDS_HURT = new Identifier("midnightlurker", "voidhands_hurt");
	public static final Identifier VOIDHANDS_SHRIEK = new Identifier("midnightlurker", "voidhands_shriek");
	public static final Identifier STATIC = new Identifier("midnightlurker", "static");
	public static final Identifier PHANTOM_HEAD_SCREAM = new Identifier("midnightlurker", "phantom_head_scream");
	public static final Identifier LURKERFOOTSTEPS = new Identifier("midnightlurker", "lurkerfootsteps");
	public static final Identifier THIRTEEN_AMBIENT = new Identifier("midnightlurker", "thirteen_ambient");
	public static final Identifier LURKER_STUNNED = new Identifier("midnightlurker", "lurker_stunned");
	public static final Identifier LURKER_TAUNT = new Identifier("midnightlurker", "lurker_taunt");
	public static final Identifier LURKER_STUN_OVER = new Identifier("midnightlurker", "lurker_stun_over");
	
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
