package net.mcreator.midnightlurker.procedures;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MidnightLurkerHiderEntityIsHurtProcedure {

	public static boolean execute(WorldAccess world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return true;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
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
					if (entity instanceof MidnightLurkerHiderEntity && sourceentity instanceof PlayerEntity) {
						return false;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof MidnightLurkerHiderEntity && sourceentity instanceof PlayerEntity) {
			if (!world.getEntitiesByClass(PlayerEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
				if (!entity.getWorld().isClient())
					entity.discard();
				if (world instanceof World _level) {
					if (!_level.isClient()) {
						_level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
					} else {
						_level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
					}
				}
                ((MidnightLurkerHiderEntity) entity).setAnimation("teleport8");
                if (!((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 1, z))).getBlock() == Blocks.WATER)
						|| !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER) || !((world.getBlockState(BlockPos.ofFloored(x, y - 0, z))).getBlock() == Blocks.WATER)) {
					if (world instanceof ServerWorld _level) {
						Entity entityToSpawn = MidnightlurkerModEntities.VOID_GATEWAY.spawn(_level, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), SpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYaw(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
		return true;
	}
}
