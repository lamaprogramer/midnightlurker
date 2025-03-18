package net.mcreator.midnightlurker.util.animations;

public enum Animations {

    TELEPORT_1("teleport");

    private final String value;
    Animations(String animationName) {
        this.value = animationName;
    }

    public String getValue() {
        return this.value;
    }
}
