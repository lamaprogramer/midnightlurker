package net.mcreator.midnightlurker.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Objects;

public class MidnightlurkerModVariables {

	public static void init() {
		ServerPlayNetworking.registerGlobalReceiver(MidnightlurkerMod.CHANNEL_ID_VARIABLES, SavedDataSyncMessage::handler);
		ClientPlayNetworking.registerGlobalReceiver(MidnightlurkerMod.CHANNEL_ID, PlayerVariablesSyncMessage::handler);
	}

	public static class EventBusVariableHandlers {
//		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
//			if (!event.getEntity().getWorld().isClient())
//				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
//		}


//		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
//			if (!event.getEntity().getWorld().isClient()) {
//				PersistentState worlddata = WorldVariables.get(event.getEntity().level());
//				if (worlddata != null)
//					MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
//			}
//		}
	}

	public static class WorldVariables extends PersistentState {
		public static final String DATA_NAME = "midnightlurker_worldvars";
		public double midnightlurkeroverhauledrewardrandom = 0;
		public double midnightlurkeroverhauledinsanitytimer = 0.0;
		public double midnightlurkeroverhauledinstage = 0;
		public double midnightlurkerinsanitytimactivate = 0;
		public double midnightlurkerinsanityactive = 0;
		public double NeutralrunRandom = 0;
		public double midnighthealthboost = 0;
		public boolean lurkerdevoverlay = false;

		public static WorldVariables load(NbtCompound tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(NbtCompound nbt) {
			midnightlurkeroverhauledrewardrandom = nbt.getDouble("midnightlurkeroverhauledrewardrandom");
			midnightlurkeroverhauledinsanitytimer = nbt.getDouble("midnightlurkeroverhauledinsanitytimer");
			midnightlurkeroverhauledinstage = nbt.getDouble("midnightlurkeroverhauledinstage");
			midnightlurkerinsanitytimactivate = nbt.getDouble("midnightlurkerinsanitytimactivate");
			midnightlurkerinsanityactive = nbt.getDouble("midnightlurkerinsanityactive");
			NeutralrunRandom = nbt.getDouble("NeutralrunRandom");
			midnighthealthboost = nbt.getDouble("midnighthealthboost");
			lurkerdevoverlay = nbt.getBoolean("lurkerdevoverlay");
		}

		@Override
		public NbtCompound writeNbt(NbtCompound nbt) {
			nbt.putDouble("midnightlurkeroverhauledrewardrandom", midnightlurkeroverhauledrewardrandom);
			nbt.putDouble("midnightlurkeroverhauledinsanitytimer", midnightlurkeroverhauledinsanitytimer);
			nbt.putDouble("midnightlurkeroverhauledinstage", midnightlurkeroverhauledinstage);
			nbt.putDouble("midnightlurkerinsanitytimactivate", midnightlurkerinsanitytimactivate);
			nbt.putDouble("midnightlurkerinsanityactive", midnightlurkerinsanityactive);
			nbt.putDouble("NeutralrunRandom", NeutralrunRandom);
			nbt.putDouble("midnighthealthboost", midnighthealthboost);
			nbt.putBoolean("lurkerdevoverlay", lurkerdevoverlay);
			return nbt;
		}

		public void syncData(WorldAccess world) {
			this.setDirty(true);
			if (world instanceof World level && !level.isClient())
				ClientPlayNetworking.send(MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(1).writeNbt(this.writeNbt(new NbtCompound())));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(WorldAccess world) {
			if (world instanceof ServerWorld level) {
				return level.getPersistentStateManager().getOrCreate(
                        new Type<>(WorldVariables::new, WorldVariables::load, DataFixTypes.LEVEL), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends PersistentState {
		public static final String DATA_NAME = "midnightlurker_mapvars";

		public static MapVariables load(NbtCompound tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(NbtCompound nbt) {
		}

		@Override
		public NbtCompound writeNbt(NbtCompound nbt) {
			return nbt;
		}

		public void syncData(WorldAccess world) {
			this.setDirty(true);
			if (world instanceof World && !world.isClient())
				ClientPlayNetworking.send(MidnightlurkerMod.CHANNEL_ID_VARIABLES, PacketByteBufs.create().writeInt(0).writeNbt(new NbtCompound()));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(WorldAccess world) {
			if (world instanceof ServerWorldAccess serverLevelAcc) {
				return serverLevelAcc.getServer().getWorld(World.OVERWORLD).getPersistentStateManager().getOrCreate(new Type<>(MapVariables::new, MapVariables::load, DataFixTypes.SAVED_DATA_MAP_DATA), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public static void handler(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
			int type = buf.readInt();
			PersistentState data = type == 0 ? new MapVariables() : new WorldVariables();

			if (data instanceof MapVariables _mapvars) {
				_mapvars.read(buf.readNbt());
			} else {
                WorldVariables _worldvars = (WorldVariables) data;
                _worldvars.read(Objects.requireNonNull(buf.readNbt()));
            }

			if (type == 0)
				MapVariables.clientSide = (MapVariables) data;
			else
				WorldVariables.clientSide = (WorldVariables) data;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public static void handler(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
			NbtCompound nbt = buf.readNbt();
			IEntityDataSaver variables = (IEntityDataSaver) MinecraftClient.getInstance().player;
			
			variables.getPersistentData().putDouble("DeathJumpActive", nbt.getDouble("DeathJumpActive"));
			variables.getPersistentData().putDouble("DeathJumpTimer", nbt.getDouble("DeathJumpTimer"));
			variables.getPersistentData().putDouble("DeathJumpShake", nbt.getDouble("DeathJumpShake"));
			variables.getPersistentData().putDouble("ScreenShake", nbt.getDouble("ScreenShake"));
			variables.getPersistentData().putDouble("InsanityStage", nbt.getDouble("InsanityStage"));
			variables.getPersistentData().putDouble("InsanityTimer", nbt.getDouble("InsanityTimer"));
			variables.getPersistentData().putDouble("InsanityAktive", nbt.getDouble("InsanityAktive"));
			variables.getPersistentData().putDouble("InsanityReset", nbt.getDouble("InsanityReset"));
			variables.getPersistentData().putDouble("JumpscareActive", nbt.getDouble("JumpscareActive"));
			variables.getPersistentData().putDouble("JumpscareTimer", nbt.getDouble("JumpscareTimer"));
			variables.getPersistentData().putDouble("JumpscareRandom", nbt.getDouble("JumpscareRandom"));
			variables.getPersistentData().putDouble("StaticRender", nbt.getDouble("StaticRender"));
			variables.getPersistentData().putDouble("encounternumber", nbt.getDouble("encounternumber"));
		}
	}
}
