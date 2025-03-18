
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerUnprovokedOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerUnprovokedOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.MidnightLurkerEntityDiesProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerUnprovokedThisEntityKillsAnotherOneProcedure;
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
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class MidnightLurkerUnprovokedEntity extends MidnightLurkerEntity {
	public MidnightLurkerUnprovokedEntity(EntityType<MidnightLurkerUnprovokedEntity> type, World world) {
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
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(4, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				return super.shouldContinue() && entity.isTouchingWater();
			}
		});
		this.targetSelector.add(7, new ActiveTargetGoal(this, PigEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}
		});
		this.targetSelector.add(8, new ActiveTargetGoal(this, CowEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}
		});
		this.targetSelector.add(9, new ActiveTargetGoal(this, SheepEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}
		});
		this.targetSelector.add(10, new ActiveTargetGoal(this, ChickenEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 70);
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
		MidnightLurkerEntityDiesProcedure.execute(this.getWorld(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerUnprovokedOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void updateKilledAdvancementCriterion(Entity entity, int score, DamageSource damageSource) {
		super.updateKilledAdvancementCriterion(entity, score, damageSource);
		MidnightLurkerUnprovokedThisEntityKillsAnotherOneProcedure.execute(this.getWorld(), entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerUnprovokedOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, 15, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
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
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
			}
			if (this.isSneaking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("backturned"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running2"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
