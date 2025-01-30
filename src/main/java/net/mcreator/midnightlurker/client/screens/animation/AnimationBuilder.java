package net.mcreator.midnightlurker.client.screens.animation;

import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class AnimationBuilder {
    private final Map<Integer, Identifier> frameMap = new HashMap<>();

    public AnimationBuilder() {}

    public AnimationBuilder addFrame(int frame, Identifier id) {
        this.frameMap.put(frame, id);
        return this;
    }

    public Map<Integer, Identifier> build() {
        return this.frameMap;
    }
}
