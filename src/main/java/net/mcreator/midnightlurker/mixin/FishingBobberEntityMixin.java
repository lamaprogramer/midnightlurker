package net.mcreator.midnightlurker.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancement/criterion/FishingRodHookedCriterion;trigger(Lnet/minecraft/server/network/ServerPlayerEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/projectile/FishingBobberEntity;Ljava/util/Collection;)V"))
    private void updateUse(ItemStack usedItem, CallbackInfoReturnable<Integer> cir, @Local PlayerEntity entity) {
        if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;
		if (entityData.getPersistentData().getDouble("InsanityStage") < 7) {
			if (entityData.getPersistentData().getDouble("InsanityTimer") >= 400) {
				double _setval = entityData.getPersistentData().getDouble("InsanityTimer") - 200;
				entityData.getPersistentData().putDouble("InsanityTimer", _setval);
			}
		}
    }
}
