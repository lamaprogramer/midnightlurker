package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.client.screens.*;

public class MidnightlurkerHudRenders {
    public static void init() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new DeathJumpscareOverlay()));
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new InsanityBarOverlay()));

        HudRenderCallback.EVENT.register(new Insanityoverlay1Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay2Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay3Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay4Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay5Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay6Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay7Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay8Overlay());
        HudRenderCallback.EVENT.register(new Insanityoverlay9Overlay());
        HudRenderCallback.EVENT.register(new InsanityoverlayOverlay());

        HudRenderCallback.EVENT.register(new JumpRedFlash1Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash2Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash3Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash4Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash5Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash6Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash7Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash8Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash9Overlay());
        HudRenderCallback.EVENT.register(new JumpRedFlash10Overlay());

        HudRenderCallback.EVENT.register(new Jumpscare1Stage0Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage3Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage4Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage5Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare1Stage6Overlay());

        HudRenderCallback.EVENT.register(new Jumpscare2Stage0Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage3Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage4Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage5Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Stage6Overlay());

        HudRenderCallback.EVENT.register(new Jumpscare3Stage0Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage3Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage4Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage5Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Stage6Overlay());

        HudRenderCallback.EVENT.register(new Jumpscare12Stage0Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare22Stage1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare32Stage2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare42Stage3Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare52Stage4Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare62Stage5Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare72Stage6Overlay());
        HudRenderCallback.EVENT.register(new LurkStatic1Overlay());
        HudRenderCallback.EVENT.register(new LurkStatic2Overlay());

    }
}
