package net.mcreator.midnightlurker.util;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SoundUtil {
    public static void playsound(WorldAccess world, double x, double y, double z, SoundEvent soundEvent, SoundCategory category, float volume, float pitch) {
        if (world instanceof World level) {
            if (!level.isClient()) {
                level.playSound(null, BlockPos.ofFloored(x, y, z), soundEvent, category, volume, pitch);
            } else {
                level.playSoundAtBlockCenter(BlockPos.ofFloored(x, y, z), soundEvent, category, volume, pitch, false);
            }
        }
    }
}
