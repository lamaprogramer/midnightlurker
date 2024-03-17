package net.mcreator.midnightlurker.procedures;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

import org.jetbrains.annotations.Nullable;

import java.io.File;


public class InsanityFoodReduceProcedure implements UseItemCallback {
    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity entity, World world, Hand hand) {
        if (entity == null)
            return TypedActionResult.pass(null);
        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
        if (entity.getMainHandStack().getItem() == Items.GOLDEN_APPLE) {
            if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7
                    && ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") > 0) {
                {
                    double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") - 1;
                    dataSaver.getPersistentData().putDouble("InsanityStage", _setval);
                    dataSaver.syncPlayerVariables(entity);
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
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
        } else if (entity.getMainHandStack().getItem() == Items.GOLDEN_CARROT) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 2200) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 2000;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.CARROT || entity.getMainHandStack().getItem() == Items.BREAD) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 400) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 200;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.BAKED_POTATO || entity.getMainHandStack().getItem() == Items.POTATO) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 300) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 100;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.PUMPKIN_PIE) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 1800) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 1600;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.BEETROOT_SOUP || entity.getMainHandStack().getItem() == Items.MUSHROOM_STEW || entity.getMainHandStack().getItem() == Items.RABBIT_STEW) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 1800) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 1600;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.GLOW_BERRIES || entity.getMainHandStack().getItem() == Items.SWEET_BERRIES || entity.getMainHandStack().getItem() == Items.MELON_SLICE || entity.getMainHandStack().getItem() == Items.DRIED_KELP || entity.getMainHandStack().getItem() == Items.BEETROOT) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 300) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 100;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.APPLE) {
            if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 4200) {
                {
                    double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 4000;
                    
                    dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                    dataSaver.syncPlayerVariables(entity);
                    
                }
            }
        } else if (entity.getMainHandStack().getItem() == Items.PUFFERFISH) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 2000;
                
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
                
            }
        } else if (entity.getMainHandStack().getItem() == Items.ROTTEN_FLESH || entity.getMainHandStack().getItem() == Items.SPIDER_EYE) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 1000;
                
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
                
            }
        } else if (entity.getMainHandStack().getItem() == Items.POISONOUS_POTATO) {
            {
                double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") + 1500;
                dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
                dataSaver.syncPlayerVariables(entity);
            }
        }
        return TypedActionResult.pass(entity.getMainHandStack());
    }
}
