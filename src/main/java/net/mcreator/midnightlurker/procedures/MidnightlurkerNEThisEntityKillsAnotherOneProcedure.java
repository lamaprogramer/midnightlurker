package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MidnightlurkerNEThisEntityKillsAnotherOneProcedure {
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
		if (world instanceof World level) {
			if (!level.isClient()) {
				level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
			} else {
				level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1, false);
			}
		}
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!world.getEntitiesByClass(MidnightlurkerNEEntity.class, Box.of(new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
				if (!EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).getWorld().isClient())
					EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).discard();
			}
		});
	}
}
