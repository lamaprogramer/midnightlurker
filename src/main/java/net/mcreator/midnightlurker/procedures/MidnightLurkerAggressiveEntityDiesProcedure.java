package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveEntityDiesProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerWorld level) {
			level.getServer().getCommandManager().executeWithPrefix(
					new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
					"/stopsound @a * midnightlurker:lurkerchase");

			level.getServer().getCommandManager().executeWithPrefix(
					new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
					"/stopsound @a * midnightlurker:lurkerchase2");
		}

		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive > 0) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost < 5) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost + 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		IEntityDataSaver entityDataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d(x, y, z), 100, 100, 100);
		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 100)
				&& entityDataSaver.getPersistentData().getDouble("InsanityStage") == 7) {

			entityDataSaver.getPersistentData().putDouble("InsanityStage", 0);
			entityDataSaver.getPersistentData().putDouble("InsanityTimer", 0);
			entityDataSaver.getPersistentData().putDouble("InsanityAktive", 0);

			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
