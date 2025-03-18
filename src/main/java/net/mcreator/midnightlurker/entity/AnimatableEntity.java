package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.util.animations.Animations;

public interface AnimatableEntity {
    String getSyncedAnimation();
    void setAnimation(String animation);
    void setAnimation(Animations animation);
}


