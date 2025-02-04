
package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerRuntrueOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerRuntrueOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.LurkerinwaterconditionProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerEntityDiesProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.*;

public class MidnightLurkerRuntrueEntity extends MidnightLurkerEntity {
	public MidnightLurkerRuntrueEntity(EntityType<MidnightLurkerRuntrueEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkervoidgatenomouth")
		);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new FleeEntityGoal<>(this, PlayerEntity.class, (float) 100, 1, 1.2));
		this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(5, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightLurkerRuntrueEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightLurkerRuntrueEntity.this;
				return super.shouldContinue() && entity.isTouchingWater();
			}
		});
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerfootsteps")), 0.15f, 1);
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
		if (!MidnightLurkerAggressiveEntityIsHurtProcedure.execute(this, source.getAttacker()))
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
		MidnightLurkerRuntrueOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerRuntrueOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	public static void init() {
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.42);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && !this.isAttacking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running6"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim6"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking6"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle6"));
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
