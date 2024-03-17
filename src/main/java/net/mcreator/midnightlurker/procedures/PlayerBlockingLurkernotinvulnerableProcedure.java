package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PlayerBlockingLurkernotinvulnerableProcedure {

	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
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
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean()) {
					if (entity instanceof PlayerEntity && (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerFakerEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerFakerAggroEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerFakerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerRuntrueEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerShadowEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerShadowEyesEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty()
							|| !world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 10, 10, 10), e -> true).isEmpty())) {
                        LivingEntity _livEnt = (LivingEntity) entity;
                        if (_livEnt.isBlocking()) {
                            PlayerEntity _player = (PlayerEntity) entity;
                            _player.getItemCooldownManager().set(Items.SHIELD, 50);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
