package net.mcreator.midnightlurker.entity.spawnconditions.init;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.*;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class SpookyambienceentityOnInitialEntitySpawnProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		if (MidnightlurkerMod.CONFIG.shouldDoSpookyAmbience()) {
			if (!world.getEntitiesByClass(MidnightLurkerFakerEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerFakerAggroEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerFakerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerInvisibleEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerSeenAngressiveEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerStalkingEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerBackturnedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerHiderEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerRunawayEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerShadowEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerShadowEyesEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerShapeshifterEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerUnprovokedEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkertposeEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerStareEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !world.getEntitiesByClass(MidnightLurkerWatcherEntity.class, Box.of(new Vec3d(x, y, z), 700, 700, 700), e -> true).isEmpty()
					|| !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 700)) {

				if (world instanceof ServerWorld level) {
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:spookyambience record @a ~ ~ ~ 500 1");

					if (Math.random() >= 0.8) {
						level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:thirteen_ambient record @a ~ ~ ~ 500 1");
					}
				}
			}
		}
	}
}
