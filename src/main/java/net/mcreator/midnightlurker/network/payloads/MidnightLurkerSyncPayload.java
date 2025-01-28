package net.mcreator.midnightlurker.network.payloads;

import net.mcreator.midnightlurker.network.MidnightLurkerNetworking;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record MidnightLurkerSyncPayload(String name, double value) implements CustomPayload {
    public static final CustomPayload.Id<MidnightLurkerSyncPayload> ID = new CustomPayload.Id<>(MidnightLurkerNetworking.SYNC_PLAYER_DATA);
    public static final PacketCodec<RegistryByteBuf, MidnightLurkerSyncPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, MidnightLurkerSyncPayload::name,
            PacketCodecs.DOUBLE, MidnightLurkerSyncPayload::value,
            MidnightLurkerSyncPayload::new
    );


    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
