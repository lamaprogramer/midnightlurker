package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.world.PersistentState;


public class MidnightlurkerCallbacks {
    public static void init() {
        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {
            IEntityDataSaver original = (IEntityDataSaver)  oldPlayer;
            IEntityDataSaver clone = (IEntityDataSaver)  newPlayer;

            clone.getPersistentData().putDouble("DeathJumpActive", original.getPersistentData().getDouble("DeathJumpActive"));
            clone.getPersistentData().putDouble("DeathJumpTimer", original.getPersistentData().getDouble("DeathJumpTimer"));
            clone.getPersistentData().putDouble("DeathJumpShake", original.getPersistentData().getDouble("DeathJumpShake"));
            clone.getPersistentData().putDouble("ScreenShake", original.getPersistentData().getDouble("ScreenShake"));
            clone.getPersistentData().putDouble("InsanityStage", original.getPersistentData().getDouble("InsanityStage"));
            clone.getPersistentData().putDouble("InsanityTimer", original.getPersistentData().getDouble("InsanityTimer"));
            clone.getPersistentData().putDouble("InsanityAktive", original.getPersistentData().getDouble("InsanityAktive"));
            clone.getPersistentData().putDouble("InsanityReset", original.getPersistentData().getDouble("InsanityReset"));
            clone.getPersistentData().putDouble("JumpscareActive", original.getPersistentData().getDouble("JumpscareActive"));
            clone.getPersistentData().putDouble("JumpscareTimer", original.getPersistentData().getDouble("JumpscareTimer"));
            clone.getPersistentData().putDouble("JumpscareRandom", original.getPersistentData().getDouble("JumpscareRandom"));
            clone.getPersistentData().putDouble("StaticRender", original.getPersistentData().getDouble("StaticRender"));
			if (alive) {
                clone.getPersistentData().putDouble("encounternumber", original.getPersistentData().getDouble("encounternumber"));
			}
        });

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            ((IEntityDataSaver)newPlayer).syncPlayerVariables(newPlayer);
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            //((IEntityDataSaver)handler.getPlayer()).syncPlayerVariables(handler.getPlayer());
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            PersistentState mapdata = MidnightlurkerModVariables.MapVariables.get(handler.getPlayer().getWorld());
            PersistentState worlddata = MidnightlurkerModVariables.WorldVariables.get(handler.getPlayer().getWorld());
//            if (mapdata != null)
//                ClientPlayNetworking.send(MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(0).writeNbt(mapdata.writeNbt(new NbtCompound())));
//            if (worlddata != null)
//                ClientPlayNetworking.send(MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(1).writeNbt(worlddata.writeNbt(new NbtCompound())));

        });

    }
}
