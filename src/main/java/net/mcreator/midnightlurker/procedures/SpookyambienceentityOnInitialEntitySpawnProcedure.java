package net.mcreator.midnightlurker.procedures;

import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Box;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;

import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class SpookyambienceentityOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!entity.getWorld().isClient())
				entity.discard();
		});
		lurker = new File((FabricLoader.getInstance().getGameDir().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
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
				if (mainjsonobject.get("spooky_ambience").getAsBoolean()) {
					if (!world.getEntitiesByClass(MidnightLurkerFakerEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerFakerAggroEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerFakerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerShadowEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerShadowEyesEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerCreepEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
						if (world instanceof ServerWorld _level)
							_level.getServer().getCommandManager().executeWithPrefix(
									new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
									"/playsound midnightlurker:spookyambience record @a ~ ~ ~ 500 1");
						if (Math.random() >= 0.8) {
							if (world instanceof ServerWorld _level)
								_level.getServer().getCommandManager().executeWithPrefix(
										new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
										"/playsound midnightlurker:thirteen_ambient record @a ~ ~ ~ 500 1");
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
