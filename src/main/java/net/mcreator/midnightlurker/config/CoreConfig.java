package net.mcreator.midnightlurker.config;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.core.Config;

public class CoreConfig implements Config {
    private boolean lurkerChaseMusic;
    private int lurkerSpawnRate;
    private boolean popUpJumpscare;
    private boolean jumpscareSound;
    private boolean longerLurkerChase;
    private boolean spookyAmbience;
    private boolean multiSpawning;
    private boolean insanityProgressEffect;
    private int insanityCountdownTime;
    private boolean lurkerInvulnerable;
    private int netherLurkerSpawnRate;
    private boolean amnesia;
    private boolean invisibleEntitiesSpawning;
    private boolean encountersProgressStages;

    public CoreConfig() {}

    public CoreConfig(CoreConfig copy) {
        this(
            copy.encountersProgressStages,
            copy.amnesia,
            copy.insanityCountdownTime,
            copy.insanityProgressEffect,
            copy.invisibleEntitiesSpawning,
            copy.longerLurkerChase,
            copy.jumpscareSound,
            copy.lurkerChaseMusic ,
            copy.lurkerInvulnerable,
            copy.lurkerSpawnRate,
            copy.multiSpawning,
            copy.netherLurkerSpawnRate,
            copy.popUpJumpscare,
            copy.spookyAmbience
        );
    }

    public CoreConfig(boolean encountersProgressStages, boolean amnesia, int insanityCountdownTime, boolean insanityProgressEffect, boolean invisibleEntitiesSpawning, boolean longerLurkerChase, boolean jumpscareSound, boolean lurkerChaseMusic, boolean lurkerInvulnerable, int lurkerSpawnRate, boolean multiSpawning, int netherLurkerSpawnRate, boolean popUpJumpscare, boolean spookyAmbience) {
        this.encountersProgressStages = encountersProgressStages;
        this.amnesia = amnesia;
        this.insanityCountdownTime = insanityCountdownTime;
        this.insanityProgressEffect = insanityProgressEffect;
        this.invisibleEntitiesSpawning = invisibleEntitiesSpawning;
        this.longerLurkerChase = longerLurkerChase;
        this.jumpscareSound = jumpscareSound;
        this.lurkerChaseMusic = lurkerChaseMusic;
        this.lurkerInvulnerable = lurkerInvulnerable;
        this.lurkerSpawnRate = lurkerSpawnRate;
        this.multiSpawning = multiSpawning;
        this.netherLurkerSpawnRate = netherLurkerSpawnRate;
        this.popUpJumpscare = popUpJumpscare;
        this.spookyAmbience = spookyAmbience;
    }


    @Override
    public String fileName() {
        return MidnightlurkerMod.MODID;
    }

    public boolean isAmnesia() {
        return amnesia;
    }

    public void setAmnesia(boolean amnesia) {
        this.amnesia = amnesia;
    }

    public boolean shouldDoEncountersProgressStages() {
        return encountersProgressStages;
    }

    public void setEncountersProgressStages(boolean encountersProgressStages) {
        this.encountersProgressStages = encountersProgressStages;
    }

    public int getInsanityCountdownTime() {
        return insanityCountdownTime;
    }

    public void setInsanityCountdownTime(int insanityCountdownTime) {
        this.insanityCountdownTime = insanityCountdownTime;
    }

    public boolean shouldDoInsanityProgressEffect() {
        return insanityProgressEffect;
    }

    public void setInsanityProgressEffect(boolean insanityProgressEffect) {
        this.insanityProgressEffect = insanityProgressEffect;
    }

    public boolean shouldDoInvisibleEntitiesSpawning() {
        return invisibleEntitiesSpawning;
    }

    public void setInvisibleEntitiesSpawning(boolean invisibleEntitiesSpawning) {
        this.invisibleEntitiesSpawning = invisibleEntitiesSpawning;
    }

    public boolean shouldDoJumpscareSound() {
        return jumpscareSound;
    }

    public void setJumpscareSound(boolean jumpscareSound) {
        this.jumpscareSound = jumpscareSound;
    }

    public boolean shouldDoLongerLurkerChase() {
        return longerLurkerChase;
    }

    public void setLongerLurkerChase(boolean longerLurkerChase) {
        this.longerLurkerChase = longerLurkerChase;
    }

    public boolean shouldDoLurkerChaseMusic() {
        return lurkerChaseMusic;
    }

    public void setLurkerChaseMusic(boolean lurkerChaseMusic) {
        this.lurkerChaseMusic = lurkerChaseMusic;
    }

    public boolean isLurkerInvulnerable() {
        return lurkerInvulnerable;
    }

    public void setLurkerInvulnerable(boolean lurkerInvulnerable) {
        this.lurkerInvulnerable = lurkerInvulnerable;
    }

    public int getLurkerSpawnRate() {
        return lurkerSpawnRate;
    }

    public void setLurkerSpawnRate(int lurkerSpawnRate) {
        this.lurkerSpawnRate = lurkerSpawnRate;
    }

    public boolean shouldDoMultiSpawning() {
        return multiSpawning;
    }

    public void setMultiSpawning(boolean multiSpawning) {
        this.multiSpawning = multiSpawning;
    }

    public int getNetherLurkerSpawnRate() {
        return netherLurkerSpawnRate;
    }

    public void setNetherLurkerSpawnRate(int netherLurkerSpawnRate) {
        this.netherLurkerSpawnRate = netherLurkerSpawnRate;
    }

    public boolean shouldDoPopUpJumpscare() {
        return popUpJumpscare;
    }

    public void setPopUpJumpscare(boolean popUpJumpscare) {
        this.popUpJumpscare = popUpJumpscare;
    }

    public boolean shouldDoSpookyAmbience() {
        return spookyAmbience;
    }

    public void setSpookyAmbience(boolean spookyAmbience) {
        this.spookyAmbience = spookyAmbience;
    }
}
