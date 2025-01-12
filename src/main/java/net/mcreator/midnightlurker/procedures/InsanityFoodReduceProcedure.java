package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public class InsanityFoodReduceProcedure {
    public static void execute(ItemStack itemStack, PlayerEntity entity) {
        if (entity == null)
            return;
        IEntityDataSaver entityData = (IEntityDataSaver) entity;
        if (itemStack.getItem() == Items.GOLDEN_APPLE) {
            modifyInsanityStage(entityData, entityData.getPersistentData().getDouble("InsanityStage") < 7 && entityData.getPersistentData().getDouble("InsanityStage") > 0, 1);
        } else if (itemStack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
            modifyInsanityStage(entityData, entityData.getPersistentData().getDouble("InsanityStage") < 7 && entityData.getPersistentData().getDouble("InsanityStage") > 2, 3);
            modifyInsanityStage(entityData, entityData.getPersistentData().getDouble("InsanityStage") < 7 && entityData.getPersistentData().getDouble("InsanityStage") > 1, 2);
            modifyInsanityStage(entityData, entityData.getPersistentData().getDouble("InsanityStage") < 7 && entityData.getPersistentData().getDouble("InsanityStage") > 0, 1);
        } else if (itemStack.getItem() == Items.GOLDEN_CARROT) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 2200, -2000);
        } else if (itemStack.getItem() == Items.CARROT || itemStack.getItem() == Items.BREAD) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 400, -200);
        } else if (itemStack.getItem() == Items.BAKED_POTATO || itemStack.getItem() == Items.POTATO) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 300, -100);
        } else if (itemStack.getItem() == Items.PUMPKIN_PIE) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 1800, -1600);
        } else if (itemStack.getItem() == Items.BEETROOT_SOUP || itemStack.getItem() == Items.MUSHROOM_STEW || itemStack.getItem() == Items.RABBIT_STEW) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 1800, -1600);
        } else if (itemStack.getItem() == Items.GLOW_BERRIES || itemStack.getItem() == Items.SWEET_BERRIES || itemStack.getItem() == Items.MELON_SLICE || itemStack.getItem() == Items.DRIED_KELP || itemStack.getItem() == Items.BEETROOT) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 300, -100);
        } else if (itemStack.getItem() == Items.APPLE) {
            modifyInsanityTimer(entityData, entityData.getPersistentData().getDouble("InsanityTimer") >= 4200, -4000);
        } else if (itemStack.getItem() == Items.PUFFERFISH) {
            modifyInsanityTimer(entityData, true, 1500);
        } else if (itemStack.getItem() == Items.ROTTEN_FLESH || itemStack.getItem() == Items.SPIDER_EYE) {
            modifyInsanityTimer(entityData, true, 1000);
        } else if (itemStack.getItem() == Items.POISONOUS_POTATO) {
            modifyInsanityTimer(entityData, true, 1500);
        }
    }
    
    private static void modifyInsanityTimer(IEntityDataSaver entityData, boolean condition, int increment) {
        if (condition) {
            double _setval = entityData.getPersistentData().getDouble("InsanityTimer") + increment;
            entityData.getPersistentData().putDouble("InsanityTimer", _setval);
        }
    }

    private static void modifyInsanityStage(IEntityDataSaver entityData, boolean condition, int decrement) {
        if (condition) {
            double _setval = entityData.getPersistentData().getDouble("InsanityStage") - decrement;
            entityData.getPersistentData().putDouble("InsanityStage", _setval);
        }
    }
}
