package net.mcreator.midnightlurker.util;

import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

public interface AnimationHandler {
    PlayState dynamic(AnimationState<?> animationState, boolean shouldLoop);
    PlayState dynamic(AnimationState<?> animationState, String animationName, boolean shouldLoop);

    boolean hasAnimation();
}
