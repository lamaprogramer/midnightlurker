package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.world.World;

public abstract class MidnightLurkerEntity extends AnimatableHostileMidnightLurkerEntity {
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
    protected void updatePostDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropXp(null);
        }
    }
}
