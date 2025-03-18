package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.animations.Animations;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class AnimatableHostileMidnightLurkerEntity extends HostileEntity implements GeoEntity, AnimatableEntity, AnimationHandler {
    public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(AnimatableHostileMidnightLurkerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<String> ANIMATION = DataTracker.registerData(AnimatableHostileMidnightLurkerEntity.class, TrackedDataHandlerRegistry.STRING);
    public static final TrackedData<String> TEXTURE = DataTracker.registerData(AnimatableHostileMidnightLurkerEntity.class, TrackedDataHandlerRegistry.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean isLastLoop;
    public String animationName = "empty";

    protected AnimatableHostileMidnightLurkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder
                .add(SHOOT, false)
                .add(ANIMATION, "undefined")
        );
    }

    @Override
    public void tick() {
        super.tick();

        AnimatableEntity syncable = this;
        String animation = syncable.getSyncedAnimation();
        if (!animation.equals("undefined")) {
            syncable.setAnimation("undefined");
            this.animationName = animation;
        }
    }

    @Override
    public String getSyncedAnimation() {
        return this.dataTracker.get(ANIMATION);
    }

    @Override
    public void setAnimation(String animation) {
        this.dataTracker.set(ANIMATION, animation);
    }

    @Override
    public void setAnimation(Animations animation) {
        this.dataTracker.set(ANIMATION, animation.getValue());
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "procedure", 4, this::dynamicPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public void setTexture(String texture) {
        this.dataTracker.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.dataTracker.get(TEXTURE);
    }

    protected PlayState dynamicPredicate(AnimationState<?> animationState) {
        AnimationHandler animationHandler = (AnimationHandler) this;
        return animationHandler.dynamic(animationState, false);
    }

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
}
