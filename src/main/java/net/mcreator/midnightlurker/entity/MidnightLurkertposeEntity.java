
package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkertposeOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerEntityDiesProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.*;

public class MidnightLurkertposeEntity extends MidnightLurkerEntity {
	public MidnightLurkertposeEntity(EntityType<MidnightLurkertposeEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurker")
		);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(4, new SwimGoal(this));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerhurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdeath"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (source.getSource() instanceof PlayerEntity)
			return false;
		return super.damage(source, amount);
	}

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		MidnightLurkerEntityDiesProcedure.execute(this.getWorld(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkertposeOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	public static void init() {
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("tpose"));
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
