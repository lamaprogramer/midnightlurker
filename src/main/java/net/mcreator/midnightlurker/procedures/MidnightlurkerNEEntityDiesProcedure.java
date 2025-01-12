package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightlurkerNEEntityDiesProcedure {
	public static void execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerWorld level)
			level.getServer().getCommandManager().executeWithPrefix(
					new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
					"/stopsound @a * midnightlurker:lurkerchase");
		if (world instanceof ServerWorld level)
			level.getServer().getCommandManager().executeWithPrefix(
					new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(),
					"/stopsound @a * midnightlurker:lurkerchase2");
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive > 0) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost < 5) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost + 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
