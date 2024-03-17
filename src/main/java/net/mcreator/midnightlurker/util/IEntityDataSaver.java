package net.mcreator.midnightlurker.util;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();
    void syncPlayerVariables(Entity entity);
}
