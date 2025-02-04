package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class MidnightPhantomHeadPlayerCollidesWithThisEntityProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getWorld().isClient())
			entity.discard();

		if (world instanceof ServerWorld level)
			level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/stopsound @a neutral midnightlurker:phantom_head_scream");

		if (Math.random() > 0.7) {
			IEntityDataSaver dataSaver = (IEntityDataSaver) EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100);
			if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 100)) {
				if (dataSaver.getPersistentData().getDouble("JumpscareActive") < 1) {
					dataSaver.getPersistentData().putDouble("JumpscareActive", 1);
				}

				MidnightlurkerMod.queueServerWork(18, () -> {
					if (EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100) instanceof LivingEntity _entity && !_entity.getWorld().isClient())
						_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));
				});
			}
		}
	}
}
