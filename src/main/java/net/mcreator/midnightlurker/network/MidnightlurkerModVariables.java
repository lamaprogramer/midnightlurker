package net.mcreator.midnightlurker.network;

import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.world.WorldAccess;

public class MidnightlurkerModVariables {

	public static void initServer() {

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

		public static WorldVariables load(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
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

		public void syncData(WorldAccess world) {
			this.setDirty(true);
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

		@Override
		public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
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
	}
}
