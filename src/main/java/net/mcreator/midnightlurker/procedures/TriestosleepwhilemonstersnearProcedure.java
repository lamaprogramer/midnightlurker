package net.mcreator.midnightlurker.procedures;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;


public class TriestosleepwhilemonstersnearProcedure implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity entity, World world, Hand hand, BlockHitResult hitResult) {
        if (entity == null)
            return ActionResult.PASS;
        BlockState blockState = world.getBlockState(hitResult.getBlockPos());
        if (blockState.isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("beds")))) {
            if (!(new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayerEntity _serverPlayer) {
                        return _serverPlayer.interactionManager.getGameMode() == GameMode.CREATIVE;
                    } else if (_ent.getWorld().isClient() && _ent instanceof PlayerEntity _player) {
                        return MinecraftClient.getInstance().getNetworkHandler().getPlayerListEntry(_player.getGameProfile().getId()) != null
                                && MinecraftClient.getInstance().getNetworkHandler().getPlayerListEntry(_player.getGameProfile().getId()).getGameMode() == GameMode.CREATIVE;
                    }
                    return false;
                }
            }.checkGamemode(entity))) {
                if (!world.getEntitiesByClass(HostileEntity.class, Box.of(entity.getPos(), 16, 16, 16), e -> true).isEmpty()) {
                    if (MathHelper.nextInt(Random.create(), 1, 10) == 2) {
                        if (world instanceof ServerWorld _level)
                            _level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), Vec2f.ZERO, _level, 4, "", Text.literal(""), _level.getServer(), null).withSilent(),
                                    "/playsound minecraft:ambient.cave ambient @p ~ ~ ~ 50 0.8");
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
