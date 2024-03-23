package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public class InsanityFoodReduceProcedure {
    public static void execute(ItemStack itemStack, PlayerEntity entity) {
        if (entity == null)
            return;
        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
        if (itemStack.getItem() == Items.GOLDEN_APPLE) {
            if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7
                    && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") > 0) {
                {
                    double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") - 1;
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.syncPlayerVariables(entity);
                }
            }
        } else if (itemStack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
            if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7
                    && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") > 2) {
                {
                    double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") - 3;
                    
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            } else if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7
                    && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") > 1) {
                {
                    double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") - 2;
                    
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            } else if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7
                    && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") > 0) {
                {
                    double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") - 1;
                    
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.GOLDEN_CARROT) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 2200) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 2000;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.CARROT || itemStack.getItem() == Items.BREAD) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 400) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 200;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.BAKED_POTATO || itemStack.getItem() == Items.POTATO) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 300) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 100;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.PUMPKIN_PIE) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 1800) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 1600;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.BEETROOT_SOUP || itemStack.getItem() == Items.MUSHROOM_STEW || itemStack.getItem() == Items.RABBIT_STEW) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 1800) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 1600;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.GLOW_BERRIES || itemStack.getItem() == Items.SWEET_BERRIES || itemStack.getItem() == Items.MELON_SLICE || itemStack.getItem() == Items.DRIED_KELP || itemStack.getItem() == Items.BEETROOT) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 300) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 100;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.APPLE) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 4200) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 4000;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (itemStack.getItem() == Items.PUFFERFISH) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 2000;
                
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
                
            }
        } else if (itemStack.getItem() == Items.ROTTEN_FLESH || itemStack.getItem() == Items.SPIDER_EYE) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 1000;
                
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
                
            }
        } else if (itemStack.getItem() == Items.POISONOUS_POTATO) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 1500;
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
            }
        }
    }
}
