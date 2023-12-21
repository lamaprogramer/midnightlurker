package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class LurkerangytimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == false) {
					if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 0) {
							MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = 1201;
							MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						} else {
							MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer - 1;
							MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						}
					}
					if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() && MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1) {
						if (!((Entity) world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level.isClientSide())
							((Entity) world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
					}
					if (entity.getPersistentData().getDouble("InsanityStage") == 7 && MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1) {
						entity.getPersistentData().putDouble("InsanityStage", 0);
						entity.getPersistentData().putDouble("InsanityTimer", 0);
						entity.getPersistentData().putDouble("InsanityAktive", 0);
						MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
					}
				} else if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == true) {
					if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 0) {
							MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = 2401;
							MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						} else {
							MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer - 1;
							MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						}
					}
					if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() && MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1) {
						if (!((Entity) world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level.isClientSide())
							((Entity) world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
					}
					if (entity.getPersistentData().getDouble("InsanityStage") == 7 && MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1) {
						entity.getPersistentData().putDouble("InsanityStage", 0);
						entity.getPersistentData().putDouble("InsanityTimer", 0);
						entity.getPersistentData().putDouble("InsanityAktive", 0);
						MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
						MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
						MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
					}
				}
				if (mainjsonobject.get("lurker_chase_music").getAsBoolean() == true && mainjsonobject.get("longer_lurker_chase").getAsBoolean() == false) {
					if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1199) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/playsound midnightlurker:lurkerchase neutral @a");
					}
				} else if (mainjsonobject.get("lurker_chase_music").getAsBoolean() == false && mainjsonobject.get("longer_lurker_chase").getAsBoolean() == false) {
					if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 1199) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					}
				} else if (mainjsonobject.get("lurker_chase_music").getAsBoolean() == true && mainjsonobject.get("longer_lurker_chase").getAsBoolean() == true) {
					if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 2399) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/playsound midnightlurker:lurkerchase2 neutral @a");
					}
				} else if (mainjsonobject.get("lurker_chase_music").getAsBoolean() == false && mainjsonobject.get("longer_lurker_chase").getAsBoolean() == true) {
					if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer == 2399) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerchase2")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerchase2")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == false) {
			if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer < 1201) {
					MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = 1201;
					MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
				}
			}
		} else if (mainjsonobject.get("longer_lurker_chase").getAsBoolean() == true) {
			if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer < 2401) {
					MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledtimer = 2401;
					MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
				}
			}
		}
	}
}
