
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerAggressiveOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerNENaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightlurkerNEOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.*;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
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
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class MidnightlurkerNEEntity extends MidnightLurkerEntity {
	public MidnightlurkerNEEntity(EntityType<MidnightlurkerNEEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkervoidgate")
		);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.add(4, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100) {
			@Override
			public boolean canStart() {
				World world = MidnightlurkerNEEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, MidnightlurkerNEEntity.this.getPos(), 40);
			}

			@Override
			public boolean shouldContinue() {
				World world = MidnightlurkerNEEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, MidnightlurkerNEEntity.this.getPos(), 40);
			}
		});
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightlurkerNEEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightlurkerNEEntity.this;
				return super.shouldContinue() && entity.isTouchingWater();
			}
		});
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerchasesteps")), 0.15f, 1);
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
		MidnightlurkerNEEntityDiesProcedure.execute(this.getWorld(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerAggressiveOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void updateKilledAdvancementCriterion(Entity entity, int score, DamageSource damageSource) {
		super.updateKilledAdvancementCriterion(entity, score, damageSource);
		MidnightlurkerNEThisEntityKillsAnotherOneProcedure.execute(this.getWorld(), entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightlurkerNEOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public EntityDimensions getBaseDimensions(EntityPose p_33597_) {
		Entity entity = this;
		World world = this.getWorld();
		double x = this.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return super.getBaseDimensions(p_33597_).scaled((float) MidnightLurkerAggressiveBoundingBoxScaleProcedure.execute(world, x, y, z));
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHTLURKER_NE, 1, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHTLURKER_NE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerNENaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.42);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 120);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && !this.isAttacking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	@Override
	protected PlayState dynamicPredicate(AnimationState<?> animationState) {
		AnimationHandler animationHandler = (AnimationHandler) this;

		Entity entity = this;
		World world = entity.getWorld();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		String animationName = MidnightLurkerAggressivePlayReturnedAnimationProcedure.execute(world, x, y, z, this);
		boolean shouldLoop = MidnightLurkerAggressiveLoopExternalAnimationsProcedure.execute(world, x, y, z, this);

		return animationHandler.dynamic(animationState, animationName, shouldLoop);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
