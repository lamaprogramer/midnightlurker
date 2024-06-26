package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerRunawayEntityDiesProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive > 0) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300);
		if (dataSaver.getPersistentData().getDouble("InsanityAktive") > 0) {
			{
				double _setval = 0;
				dataSaver.getPersistentData().putDouble("InsanityAktive", _setval);
				dataSaver.syncPlayerVariables(EntityUtil.getEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300));
			}
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost < 5) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost + 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		MidnightlurkerMod.queueServerWork(100, () -> {
			if (Math.random() > 0.5) {
				if (world instanceof ServerWorld _level)
					_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
							"/playsound midnightlurker:lurker_taunt neutral @a ~ ~ ~ 3 1");
			}
		});
	}
}
