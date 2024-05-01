package net.mcreator.midnightlurker.init;

public class MidnightlurkerCallbacks {
    public static void init() {
//        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
//            PersistentState mapdata = MidnightlurkerModVariables.MapVariables.get(handler.getPlayer().getWorld());
//            PersistentState worlddata = MidnightlurkerModVariables.WorldVariables.get(handler.getPlayer().getWorld());
//            if (mapdata != null)
//                ServerPlayNetworking.send(handler.getPlayer(), MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(0).writeNbt(mapdata.writeNbt(new NbtCompound())));
//            if (worlddata != null)
//                ServerPlayNetworking.send(handler.getPlayer(), MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(1).writeNbt(worlddata.writeNbt(new NbtCompound())));
//        });
    }
}
