package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
public class ShapeshifterspawnProcedure {
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
		boolean found = false;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		double Spawndeterminer = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		File lurker = new File("");
		sx = -30;
		found = false;
		for (int index0 = 0; index0 < 60; index0++) {
			sy = -30;
			for (int index1 = 0; index1 < 60; index1++) {
				sz = -30;
				for (int index2 = 0; index2 < 60; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BELL) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).CloseSpawnTimer > 2000
						&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).CloseSpawnTimer < 2100) {
					if (entity instanceof Player) {
						if (((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 1
								|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 2
								|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 3
								|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 4
								|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 5) && (entity.level.dimension()) == Level.OVERWORLD) {
							if (!(!world.getEntitiesOfClass(MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 600, 600, 600), e -> true).isEmpty())) {
								spawnx = x + Mth.nextInt(RandomSource.create(), -12, 12);
								spawny = y + Mth.nextInt(RandomSource.create(), -12, 12);
								spawnz = z + Mth.nextInt(RandomSource.create(), -12, 12);
							}
							if (world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz)) && !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
								if (Math.random() > 0.7) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new MidnightLurkerShapeshifterEntity(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER.get(), _level);
										entityToSpawn.moveTo(spawnx, spawny, spawnz, world.getRandom().nextFloat() * 360F, 0);
										if (entityToSpawn instanceof Mob _mobToSpawn)
											_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										_level.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
