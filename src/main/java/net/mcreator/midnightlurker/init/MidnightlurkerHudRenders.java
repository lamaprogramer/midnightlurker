package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.client.screens.*;

public class MidnightlurkerHudRenders {
    public static void init() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new DeathJumpscareOverlay()));
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new InsanityBarOverlay()));

        HudRenderCallback.EVENT.register(new InsanityOverlay());
        HudRenderCallback.EVENT.register(new JumpRedFlashOverlay());

        HudRenderCallback.EVENT.register(new Jumpscare1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Overlay());

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
