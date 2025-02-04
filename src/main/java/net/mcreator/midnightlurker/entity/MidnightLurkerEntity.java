package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class MidnightLurkerEntity extends HostileEntity implements GeoEntity, AnimatableEntity {
    public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerEntity.class, TrackedDataHandlerRegistry.STRING);
    public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerEntity.class, TrackedDataHandlerRegistry.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected MidnightLurkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        setGlowing(MidnightlurkerMod.DEBUG_MODE);
        setAiDisabled(false);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.isOf(DamageTypes.IN_FIRE))
            return false;
        if (source.getSource() instanceof PersistentProjectileEntity)
            return false;
        if (source.getSource() instanceof PotionEntity || source.getSource() instanceof AreaEffectCloudEntity)
            return false;
        if (source.isOf(DamageTypes.FALL))
            return false;
        if (source.isOf(DamageTypes.CACTUS))
            return false;
        if (source.isOf(DamageTypes.DROWN))
            return false;
        if (source.isOf(DamageTypes.LIGHTNING_BOLT))
            return false;
        if (source.isOf(DamageTypes.EXPLOSION))
            return false;
        if (source.isOf(DamageTypes.TRIDENT))
            return false;
        if (source.isOf(DamageTypes.FALLING_ANVIL))
            return false;
        if (source.isOf(DamageTypes.DRAGON_BREATH))
            return false;
        if (source.isOf(DamageTypes.WITHER))
            return false;
        if (source.isOf(DamageTypes.WITHER_SKULL))
            return false;
        return super.damage(source, amount);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder
                .add(SHOOT, false)
                .add(ANIMATION, "undefined")
        );
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
    protected void updatePostDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropXp(null);
        }
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
}
