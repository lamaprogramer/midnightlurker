package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class JumpscareTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
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
				if (mainjsonobject.get("jumpscare_sound").getAsBoolean() == true) {
					if (entity.getPersistentData().getDouble("JumpscareTimer") == 31 && entity.getPersistentData().getDouble("JumpscareActive") > 0) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/playsound midnightlurker:lurkerjumpscare neutral @p");
					}
				}
				if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkeranger")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity.getPersistentData().getDouble("JumpscareActive") == 1) {
			if (entity.getPersistentData().getDouble("JumpscareTimer") == 0) {
				entity.getPersistentData().putDouble("JumpscareTimer", 46);
			}
		}
		if (entity.getPersistentData().getDouble("JumpscareActive") == 1 && entity.getPersistentData().getDouble("JumpscareTimer") == 1) {
			entity.getPersistentData().putDouble("JumpscareActive", 0);
			entity.getPersistentData().putDouble("JumpscareRandom", (Mth.nextInt(RandomSource.create(), 0, 2)));
		}
		if (entity.getPersistentData().getDouble("JumpscareTimer") > 0) {
			entity.getPersistentData().putDouble("JumpscareTimer", (entity.getPersistentData().getDouble("JumpscareTimer") - 1));
		}
		if (entity.getPersistentData().getDouble("JumpscareActive") == 1 && (entity.getPersistentData().getDouble("JumpscareTimer") == 29 || entity.getPersistentData().getDouble("JumpscareTimer") == 28
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 27 || entity.getPersistentData().getDouble("JumpscareTimer") == 26 || entity.getPersistentData().getDouble("JumpscareTimer") == 25
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 24 || entity.getPersistentData().getDouble("JumpscareTimer") == 23 || entity.getPersistentData().getDouble("JumpscareTimer") == 22
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 21 || entity.getPersistentData().getDouble("JumpscareTimer") == 20 || entity.getPersistentData().getDouble("JumpscareTimer") == 19
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 18 || entity.getPersistentData().getDouble("JumpscareTimer") == 17 || entity.getPersistentData().getDouble("JumpscareTimer") == 16
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 15 || entity.getPersistentData().getDouble("JumpscareTimer") == 14 || entity.getPersistentData().getDouble("JumpscareTimer") == 13
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 12 || entity.getPersistentData().getDouble("JumpscareTimer") == 11 || entity.getPersistentData().getDouble("JumpscareTimer") == 10
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 9 || entity.getPersistentData().getDouble("JumpscareTimer") == 8 || entity.getPersistentData().getDouble("JumpscareTimer") == 7
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 6 || entity.getPersistentData().getDouble("JumpscareTimer") == 5 || entity.getPersistentData().getDouble("JumpscareTimer") == 4
				|| entity.getPersistentData().getDouble("JumpscareTimer") == 3 || entity.getPersistentData().getDouble("JumpscareTimer") == 2 || entity.getPersistentData().getDouble("JumpscareTimer") == 1)) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 155, 0, false, false));
			world.addParticle((SimpleParticleType) (MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), -6, 6)), (y + Mth.nextDouble(RandomSource.create(), 0, 6)),
					(z + Mth.nextDouble(RandomSource.create(), -6, 6)), 0, 0, 0);
		}
		if (entity.getPersistentData().getDouble("JumpscareTimer") > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == true) {
			return true;
		} else if (entity.getPersistentData().getDouble("JumpscareTimer") > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean() == false) {
			return false;
		}
		return false;
	}
}
