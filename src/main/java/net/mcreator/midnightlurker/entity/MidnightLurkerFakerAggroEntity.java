
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerAggressiveOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerFakerSpawnmainProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerFakerAggroOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.LurkerinwaterconditionProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveLoopExternalAnimationsProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressivePlayReturnedAnimationProcedure;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class MidnightLurkerFakerAggroEntity extends MidnightLurkerEntity {
	public MidnightLurkerFakerAggroEntity(EntityType<MidnightLurkerFakerAggroEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
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
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(4, new WanderAroundGoal(this, 0.4) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerFakerAggroEntity.this.getX();
				double y = MidnightLurkerFakerAggroEntity.this.getY();
				double z = MidnightLurkerFakerAggroEntity.this.getZ();
				World world = MidnightLurkerFakerAggroEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerFakerAggroEntity.this.getX();
				double y = MidnightLurkerFakerAggroEntity.this.getY();
				double z = MidnightLurkerFakerAggroEntity.this.getZ();
				World world = MidnightLurkerFakerAggroEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}
		});
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerFakerAggroEntity.this.getX();
				double y = MidnightLurkerFakerAggroEntity.this.getY();
				double z = MidnightLurkerFakerAggroEntity.this.getZ();
				World world = MidnightLurkerFakerAggroEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerFakerAggroEntity.this.getX();
				double y = MidnightLurkerFakerAggroEntity.this.getY();
				double z = MidnightLurkerFakerAggroEntity.this.getZ();
				World world = MidnightLurkerFakerAggroEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}
		});
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightLurkerFakerAggroEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightLurkerFakerAggroEntity.this;
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
		return Registries.SOUND_EVENT.get(Identifier.of("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.generic.death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		return false;
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerAggressiveOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerFakerAggroOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO, 7, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_AGGRO, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerFakerSpawnmainProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.42);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && !this.isAttacking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking4"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim4"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running4"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle4"));
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
