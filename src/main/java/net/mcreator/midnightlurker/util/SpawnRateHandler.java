package net.mcreator.midnightlurker.util;

public class SpawnRateHandler {
    private static final double[] SPAWN_RATES = {0.9, 0.8, 0.6, 0.4, 0.0};

    public static boolean shouldSpawn(int rate) {
        return Math.random() >= SPAWN_RATES[rate-1];
    }
}
