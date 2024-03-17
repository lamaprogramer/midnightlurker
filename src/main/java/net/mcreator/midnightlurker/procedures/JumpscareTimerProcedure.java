package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class JumpscareTimerProcedure {
    public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity; 
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
				if (mainjsonobject.get("jumpscare_sound").getAsBoolean()) {
					if (dataSaver.getPersistentData().getDouble("JumpscareTimer") == 31
							&& dataSaver.getPersistentData().getDouble("JumpscareActive") > 0) {
						if (world instanceof ServerWorld _level)
							_level.getServer().getCommandManager().executeWithPrefix(
									new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
									"/playsound midnightlurker:lurkerjumpscare neutral @p");
					}
				}
				if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("pop_up_jumpscare").getAsBoolean()) {
					if (world instanceof World _level) {
						if (!_level.isClient()) {
							_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0);
						} else {
							_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1) {
			if (dataSaver.getPersistentData().getDouble("JumpscareTimer") == 0) {
				{
					double _setval = 46;
					dataSaver.getPersistentData().putDouble("JumpscareTimer", _setval);
					dataSaver.syncPlayerVariables(entity);
				}
			}
		}
		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1
				&& dataSaver.getPersistentData().getDouble("JumpscareTimer") == 1) {
			{
				double _setval = 0;
				dataSaver.getPersistentData().putDouble("JumpscareActive", _setval);
				dataSaver.syncPlayerVariables(entity);
			}
			{
				double _setval = MathHelper.nextInt(Random.create(), 0, 2);
				dataSaver.getPersistentData().putDouble("JumpscareRandom", _setval);
				dataSaver.syncPlayerVariables(entity);
			}
		}
		if (dataSaver.getPersistentData().getDouble("JumpscareTimer") > 0) {
			{
				double _setval = dataSaver.getPersistentData().getDouble("JumpscareTimer") - 1;
				dataSaver.getPersistentData().putDouble("JumpscareTimer", _setval);
				dataSaver.syncPlayerVariables(entity);
			}
		}
		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1
				&& dataSaver.getPersistentData().getDouble("JumpscareTimer") <= 29
				&& dataSaver.getPersistentData().getDouble("JumpscareTimer") >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.getWorld().isClient())
				_entity.addStatusEffect(new StatusEffectInstance(MidnightlurkerModMobEffects.INSANITY, 155, 0, false, false));
			world.addParticle(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE, (x + MathHelper.nextDouble(Random.create(), -6, 6)), (y + MathHelper.nextDouble(Random.create(), 0, 6)),
					(z + MathHelper.nextDouble(Random.create(), -6, 6)), 0, 0, 0);
		}
		if (dataSaver.getPersistentData().getDouble("JumpscareTimer") > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean()) {
			return true;
		} else if (dataSaver.getPersistentData().getDouble("JumpscareTimer") > 0 && mainjsonobject.get("pop_up_jumpscare").getAsBoolean()) {
			return false;
		}
		return false;
	}
}
