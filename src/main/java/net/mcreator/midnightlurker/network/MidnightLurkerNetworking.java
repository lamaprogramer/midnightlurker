package net.mcreator.midnightlurker.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.network.payloads.MidnightLurkerSyncPayload;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class MidnightLurkerNetworking {
    public static final Identifier SYNC_PLAYER_DATA = Identifier.of(MidnightlurkerMod.MODID, "sync_player_data");

    public static void syncPlayerData(ServerPlayerEntity player, String name) {
        IEntityDataSaver playerData = (IEntityDataSaver)player;
        double insanity = playerData.getPersistentData().getDouble(name);

        ServerPlayNetworking.send(player, new MidnightLurkerSyncPayload(name, insanity));
    }

    public static void initServer() {
        PayloadTypeRegistry.playS2C().register(MidnightLurkerSyncPayload.ID, MidnightLurkerSyncPayload.CODEC);
    }

    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(MidnightLurkerSyncPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                IEntityDataSaver playerData = (IEntityDataSaver)context.player();
                //if (playerData.getPersistentData().contains(payload.name())) {
                    playerData.getPersistentData().putDouble(payload.name(), payload.value());
                //}
            });
        });
    }
}
