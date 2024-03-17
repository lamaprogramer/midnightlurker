package net.mcreator.midnightlurker.procedures;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import org.jetbrains.annotations.Nullable;


public class Destroytex2EntityIsHurtProcedure implements AttackEntityCallback {
	@Override
	public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (entity != null) {
            return execute(entity);
        }
        return ActionResult.PASS;
	}

	public static ActionResult execute(Entity entity) {
        if (entity == null)
            return ActionResult.PASS;
        if (entity instanceof Destroytex2Entity) {
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }
}
