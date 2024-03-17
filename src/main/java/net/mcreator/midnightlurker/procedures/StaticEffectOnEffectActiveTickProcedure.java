package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class StaticEffectOnEffectActiveTickProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StaticRender") == 0) {
			{
				double _setval = MathHelper.nextInt(Random.create(), 20, 45);
				((IEntityDataSaver)entity).getPersistentData().putDouble("StaticRender", _setval);
				((IEntityDataSaver)entity).syncPlayerVariables(entity);
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StaticRender") > 0) {
			{
				double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("StaticRender") - 1;
				((IEntityDataSaver)entity).getPersistentData().putDouble("StaticRender", _setval);
				((IEntityDataSaver)entity).syncPlayerVariables(entity);
			}
		}
		if (((IEntityDataSaver)entity).getPersistentData().getDouble("StaticRender") == 10) {
			if (world instanceof ServerWorld _level)
				_level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
						"/playsound midnightlurker:static record @p ~ ~ ~ 1 1");
		}
	}
}
