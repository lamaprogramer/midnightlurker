package net.mcreator.midnightlurker.mixin;

import net.mcreator.midnightlurker.entity.AnimatableEntity;
import net.mcreator.midnightlurker.procedures.*;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements IEntityDataSaver, AnimationHandler {
    @Unique
    private final LivingEntity THIS = (LivingEntity)(Object)this;
    @Unique
    public NbtCompound persistantData = new NbtCompound();
    @Unique
    private boolean isLastLoop;
    @Unique
    public String animationName = "empty";

    @Override
    public PlayState dynamic(AnimationState<?> animationState, boolean shouldLoop) {
        AnimationController<?> animationController = animationState.getController();

        if (!shouldLoop && this.isLastLoop) {
            this.isLastLoop = false;
            animationController.setAnimation(RawAnimation.begin().thenPlay(this.animationName));
            animationController.forceAnimationReset();
            return PlayState.STOP;
        }

        if (this.hasAnimation() && animationController.getAnimationState() == AnimationController.State.STOPPED) {
            if (!shouldLoop) {
                animationController.setAnimation(RawAnimation.begin().thenPlay(this.animationName));
                if (animationController.getAnimationState() == AnimationController.State.STOPPED) {
                    this.animationName = "empty";
                    animationController.forceAnimationReset();
                }
            } else {
                animationController.setAnimation(RawAnimation.begin().thenLoop(this.animationName));
                this.isLastLoop = true;
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public PlayState dynamic(AnimationState<?> animationState, String animationName, boolean shouldLoop) {
        if (!animationName.equals("empty")) {
            this.animationName = animationName;
        }
        return dynamic(animationState, shouldLoop);
    }

    @Override
    public boolean hasAnimation() {
        return !this.animationName.equals("empty");
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfo ci) {
        if (THIS instanceof PlayerEntity) {
            nbt.putDouble("DeathJumpActive", persistantData.getDouble("DeathJumpActive"));
            nbt.putDouble("DeathJumpTimer", persistantData.getDouble("DeathJumpTimer"));
            nbt.putDouble("DeathJumpShake", persistantData.getDouble("DeathJumpShake"));
            nbt.putDouble("ScreenShake", persistantData.getDouble("ScreenShake"));
            nbt.putDouble("InsanityStage", persistantData.getDouble("InsanityStage"));
            nbt.putDouble("InsanityTimer", persistantData.getDouble("InsanityTimer"));
            nbt.putDouble("InsanityAktive", persistantData.getDouble("InsanityAktive"));
            nbt.putDouble("InsanityReset", persistantData.getDouble("InsanityReset"));
            nbt.putDouble("JumpscareActive", persistantData.getDouble("JumpscareActive"));
            nbt.putDouble("JumpscareTimer", persistantData.getDouble("JumpscareTimer"));
            nbt.putDouble("JumpscareRandom", persistantData.getDouble("JumpscareRandom"));
            nbt.putDouble("StaticRender", persistantData.getDouble("StaticRender"));
            nbt.putDouble("encounternumber", persistantData.getDouble("encounternumber"));
        } else {
            for (String key : this.persistantData.getKeys()) {
                nbt.put(key, this.persistantData.get(key));
            }
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (THIS instanceof PlayerEntity) {
            persistantData.putDouble("DeathJumpActive", nbt.getDouble("DeathJumpActive"));
            persistantData.putDouble("DeathJumpTimer", nbt.getDouble("DeathJumpTimer"));
            persistantData.putDouble("DeathJumpShake", nbt.getDouble("DeathJumpShake"));
            persistantData.putDouble("ScreenShake", nbt.getDouble("ScreenShake"));
            persistantData.putDouble("InsanityStage", nbt.getDouble("InsanityStage"));
            persistantData.putDouble("InsanityTimer", nbt.getDouble("InsanityTimer"));
            persistantData.putDouble("InsanityAktive", nbt.getDouble("InsanityAktive"));
            persistantData.putDouble("InsanityReset", nbt.getDouble("InsanityReset"));
            persistantData.putDouble("JumpscareActive", nbt.getDouble("JumpscareActive"));
            persistantData.putDouble("JumpscareTimer", nbt.getDouble("JumpscareTimer"));
            persistantData.putDouble("JumpscareRandom", nbt.getDouble("JumpscareRandom"));
            persistantData.putDouble("StaticRender", nbt.getDouble("StaticRender"));
            persistantData.putDouble("encounternumber", nbt.getDouble("encounternumber"));
        } else {
            for (String key : nbt.getKeys()) {
                this.persistantData.put(key, nbt.get(key));
            }
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void updateTick(CallbackInfo ci) {
        if (this instanceof AnimatableEntity syncable) {
            String animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
                syncable.setAnimation("undefined");
                this.animationName = animation;
            }
        }

        if (THIS instanceof PlayerEntity) {
            AggroPotionAddTickProcedure.execute(THIS.getWorld(), THIS.getX(), THIS.getY(), THIS.getZ(), THIS);
            InsanityoverlayrendersProcedure.execute(THIS);
            AmnesiaStageAddProcedure.execute(THIS);
            DeathJumpTimerProcedure.execute(THIS.getWorld(), THIS);
            EncounterProcProcedure.execute(THIS);
            Insanitystage7Procedure.execute(THIS.getWorld(), THIS.getX(), THIS.getY(), THIS.getZ(), THIS);
            InsanityStageTimerProcedure.execute(THIS.getWorld(), THIS);
            JumpscareTimerProcedure.execute(THIS.getWorld(), THIS.getX(), THIS.getY(), THIS.getZ(), THIS);
            LurkerfaceparticleprocedureProcedure.execute(THIS.getWorld(), THIS);
            ScreenShakeProcedure.execute(THIS.getWorld(), THIS.getX(), THIS.getY(), THIS.getZ(), THIS);
        }
    }

    @Inject(method = "wakeUp()V", at = @At("HEAD"))
    private void updateWakeUp(CallbackInfo ci) {
        InsanitySleepProcedure.execute(THIS);
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void updateOnDeath(DamageSource damageSource, CallbackInfo ci) {
        PlayerDeathProcedure.execute(THIS.getWorld(), THIS);
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void updateDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerHitByAggroProcedure.execute(THIS.getWorld(), THIS.getX(), THIS.getY(), THIS.getZ(), THIS);
    }

    @Inject(method = "eatFood", at = @At("HEAD"))
    private void updateFood(World world, ItemStack stack, FoodComponent foodComponent, CallbackInfoReturnable<ItemStack> cir) {
        if (THIS instanceof PlayerEntity) {
            InsanityFoodReduceProcedure.execute(stack, (PlayerEntity) THIS);
        }
    }

    public NbtCompound getPersistentData() {
        return this.persistantData;
    }
}
