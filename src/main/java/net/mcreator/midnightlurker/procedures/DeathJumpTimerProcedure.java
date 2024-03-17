package net.mcreator.midnightlurker.procedures;



import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

import org.jetbrains.annotations.Nullable;

import java.io.File;


public class DeathJumpTimerProcedure {
	public static boolean execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return false;
		if (((IEntityDataSaver) entity).getPersistentData().getDouble("DeathJumpActive") == 69
				&& ((IEntityDataSaver) entity).getPersistentData().getDouble("DeathJumpActive") > 0) {
			if (world instanceof ServerWorld _level)
				_level.getServer().getCommandManager().executeWithPrefix(
						new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
						"/playsound midnightlurker:lurkerdeathjumpscare neutral @p");
		}

		IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (dataSaver.getPersistentData().getDouble("DeathJumpActive") == 1) {
			if (dataSaver.getPersistentData().getDouble("DeathJumpActive") == 0) {
				double _setval = 70;
				dataSaver.getPersistentData().putDouble("DeathJumpActive", _setval);
				dataSaver.syncPlayerVariables(entity);
			}
		}
		if (dataSaver.getPersistentData().getDouble("DeathJumpActive") == 1
				&& dataSaver.getPersistentData().getDouble("DeathJumpActive") == 1) {
			double _setval = 0;
			dataSaver.getPersistentData().putDouble("DeathJumpActive", _setval);
			dataSaver.syncPlayerVariables(entity);
		}
		if (dataSaver.getPersistentData().getDouble("DeathJumpActive") > 0) {
			double _setval = ((IEntityDataSaver) entity).getPersistentData().getDouble("DeathJumpActive") - 1;
			dataSaver.getPersistentData().putDouble("DeathJumpActive", _setval);
			dataSaver.syncPlayerVariables(entity);
		}
        return dataSaver.getPersistentData().getDouble("DeathJumpActive") > 0;
    }
}
