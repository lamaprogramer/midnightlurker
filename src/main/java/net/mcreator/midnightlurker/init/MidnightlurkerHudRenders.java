package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.mcreator.midnightlurker.client.screens.*;

public class MidnightlurkerHudRenders {
    public static void init() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new DeathJumpscareOverlay()));
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> ScreenEvents.afterRender(screen).register(new InsanityBarOverlay()));

        HudRenderCallback.EVENT.register(new JumpRedFlashOverlay());

        HudRenderCallback.EVENT.register(new Jumpscare1Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare2Overlay());
        HudRenderCallback.EVENT.register(new Jumpscare3Overlay());
        HudRenderCallback.EVENT.register(new JumpscareCapsOverlay());

        HudRenderCallback.EVENT.register(new InsanityOverlay());
        HudRenderCallback.EVENT.register(new LurkStaticOverlay());
    }
}
