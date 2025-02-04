package net.mcreator.midnightlurker.procedures;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public class TriestosleepwhilemonstersnearProcedure implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity entity, World world, Hand hand, BlockHitResult hitResult) {
        if (entity == null)
            return ActionResult.PASS;

        BlockState blockState = world.getBlockState(hitResult.getBlockPos());
        if (blockState.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("beds")))) {
            if (!entity.isCreative()) {
                if (!EntityUtil.hasNoEntityOfTypeInArea(world, HostileEntity.class, entity.getPos(), 16)) {
                    if (MathHelper.nextInt(Random.create(), 1, 10) == 2) {
                        if (world instanceof ServerWorld level) {
                            level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound minecraft:ambient.cave ambient @p ~ ~ ~ 50 0.8");
                        }
                    }
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
