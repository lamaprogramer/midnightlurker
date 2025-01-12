package net.mcreator.midnightlurker.util;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class JumpscareHandler {

    public static void renderJumpscareWithDuplicateFrames(DrawContext drawContext, IEntityDataSaver entityData, boolean criteria, Map<List<Integer>, Identifier> frameMap, int posX, int posY) {
        if (criteria) {
            System.out.println("Criteria met.");
            for (Map.Entry<List<Integer>, Identifier> frames : frameMap.entrySet()) {
                for (int frame : frames.getKey()) {
                    if (shouldDisplayFrame(entityData, frame)) {
                        drawContext.drawTexture(frames.getValue(), posX, posY, 0, 0, 1023, 528, 1023, 528);
                        //System.out.println("Drew " + frames.getValue() + " at frame id " + frame);
                    }
                }
            }
        }
    }

    public static void renderJumpscare(DrawContext drawContext, IEntityDataSaver entityData, boolean criteria, Map<Integer, Identifier> frameMap, int posX, int posY) {
        if (criteria) {
            System.out.println("Criteria met.");
            for (Map.Entry<Integer, Identifier> frame : frameMap.entrySet()) {
                if (shouldDisplayFrame(entityData, frame.getKey())) {
                    drawContext.drawTexture(frame.getValue(), posX, posY, 0, 0, 1023, 528, 1023, 528);
                    //System.out.println("Drew " + frame.getValue() + " at frame id " + frame.getKey());
                }
            }
        }
    }

    public static boolean shouldJumpscare(Entity entity, int insanityStage, int randVal) {
        if (entity == null)
            return false;

        IEntityDataSaver entityData = (IEntityDataSaver) entity;
        boolean accountForRandom = randVal >= 0 ? entityData.getPersistentData().getDouble("JumpscareRandom") == randVal : true;

        return entityData.getPersistentData().getDouble("JumpscareActive") == 1
                && entityData.getPersistentData().getDouble("InsanityStage") == insanityStage
                && accountForRandom;
    }

    public static boolean shouldDisplayFrame(IEntityDataSaver entityData, int frameId) {
        return entityData.getPersistentData().getDouble("JumpscareTimer") == frameId &&
                isJumpscareActive(entityData);
    }

    public static boolean isJumpscareActive(IEntityDataSaver entityData) {
        return entityData.getPersistentData().getDouble("JumpscareActive") == 1;
    }
}

