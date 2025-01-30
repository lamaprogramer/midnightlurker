package net.mcreator.midnightlurker.client.screens.animation;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

import java.util.Map;

public class FrameScheduler {
    private final Map<Integer, Identifier> frameMap;

    public FrameScheduler(Map<Integer, Identifier> frameMap) {
        this.frameMap = frameMap;
    }

    public void playAnimation(DrawContext drawContext, int frameId, int width, int height, int posX, int posY) {
        Identifier frame = this.frameMap.getOrDefault(frameId, null);

        if (frame != null) {
            drawContext.drawTexture(frame, posX, posY, 0, 0, width, height, width, height);
        }
    }
}
