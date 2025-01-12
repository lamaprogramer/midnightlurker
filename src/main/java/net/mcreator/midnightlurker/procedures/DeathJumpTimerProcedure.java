package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;


public class DeathJumpTimerProcedure {
	public static boolean execute(WorldAccess world, Entity entity) {
		if (entity == null)
			return false;

		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entityData.getPersistentData().getDouble("DeathJumpActive") == 69 && entityData.getPersistentData().getDouble("DeathJumpActive") > 0) {
			if (world instanceof ServerWorld level) {
				level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerdeathjumpscare neutral @p");
			}
		}

		if (entityData.getPersistentData().getDouble("DeathJumpActive") == 1) {
			if (entityData.getPersistentData().getDouble("DeathJumpActive") == 0) {
				entityData.getPersistentData().putDouble("DeathJumpActive", 70);
			}
		}

		if (entityData.getPersistentData().getDouble("DeathJumpActive") == 1 && entityData.getPersistentData().getDouble("DeathJumpActive") == 1) {
			entityData.getPersistentData().putDouble("DeathJumpActive", 0);
		}

		if (entityData.getPersistentData().getDouble("DeathJumpActive") > 0) {
			double _setval = entityData.getPersistentData().getDouble("DeathJumpActive") - 1;
			entityData.getPersistentData().putDouble("DeathJumpActive", _setval);
		}

        return entityData.getPersistentData().getDouble("DeathJumpActive") > 0;
    }
}
