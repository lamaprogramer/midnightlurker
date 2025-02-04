
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightPhantomHeadOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerFakerSpawnmainProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightPhantomHeadOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.MidnightPhantomHeadPlayerCollidesWithThisEntityProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
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

import java.util.EnumSet;

public class MidnightPhantomHeadEntity extends MidnightLurkerEntity {
	public MidnightPhantomHeadEntity(EntityType<MidnightPhantomHeadEntity> type, World world) {
		super(type, world);
		this.moveControl = new FlightMoveControl(this, 10, true);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkerphantomhead1")
		);
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		return new BirdNavigation(this, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(2, new Goal() {
			{
				this.setControls(EnumSet.of(Control.MOVE));
			}

			public boolean canStart() {
				if (MidnightPhantomHeadEntity.this.getTarget() != null && !MidnightPhantomHeadEntity.this.getMoveControl().isMoving()) {
					Entity entity = MidnightPhantomHeadEntity.this;
					return ((IEntityDataSaver) entity).getPersistentData().getDouble("lookingatphantomhead") == 0;
				} else {
					return false;
				}
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightPhantomHeadEntity.this;
				return ((IEntityDataSaver) entity).getPersistentData().getDouble("lookingatphantomhead") == 0 && MidnightPhantomHeadEntity.this.getMoveControl().isMoving() && MidnightPhantomHeadEntity.this.getTarget() != null && MidnightPhantomHeadEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = MidnightPhantomHeadEntity.this.getTarget();
				Vec3d vec3d = livingentity.getCameraPosVec(1);
				MidnightPhantomHeadEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = MidnightPhantomHeadEntity.this.getTarget();
				if (MidnightPhantomHeadEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					MidnightPhantomHeadEntity.this.tryAttack(livingentity);
				} else {
					double d0 = MidnightPhantomHeadEntity.this.squaredDistanceTo(livingentity);
					if (d0 < 40) {
						Vec3d vec3d = livingentity.getCameraPosVec(1);
						MidnightPhantomHeadEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.add(3, new Goal() {
			{
				this.setControls(EnumSet.of(Goal.Control.MOVE));
			}

			public boolean canStart() {
				if (MidnightPhantomHeadEntity.this.getTarget() != null && !MidnightPhantomHeadEntity.this.getMoveControl().isMoving()) {
					Entity entity = MidnightPhantomHeadEntity.this;
					return ((IEntityDataSaver) entity).getPersistentData().getDouble("lookingatphantomhead") > 0 || ((IEntityDataSaver) entity).getPersistentData().getDouble("AttackOnSight") == 50;
				} else {
					return false;
				}
			}

			@Override
			public boolean shouldContinue() {
				return MidnightPhantomHeadEntity.this.getMoveControl().isMoving() && MidnightPhantomHeadEntity.this.getTarget() != null && MidnightPhantomHeadEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = MidnightPhantomHeadEntity.this.getTarget();
				Vec3d vec3d = livingentity.getCameraPosVec(1);
				MidnightPhantomHeadEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.2);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = MidnightPhantomHeadEntity.this.getTarget();
				if (MidnightPhantomHeadEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					MidnightPhantomHeadEntity.this.tryAttack(livingentity);
				} else {
					double d0 = MidnightPhantomHeadEntity.this.squaredDistanceTo(livingentity);
					if (d0 < 40) {
						Vec3d vec3d = livingentity.getCameraPosVec(1);
						MidnightPhantomHeadEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.2);
					}
				}
			}
		});
		this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(5, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightPhantomHeadEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightPhantomHeadEntity.this;
				return super.shouldContinue() && entity.isTouchingWater();
			}
		});
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
	public boolean handleFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (source.isOf(DamageTypes.IN_FIRE))
			return false;
		if (source.getSource() instanceof PersistentProjectileEntity)
			return false;
		if (source.getSource() instanceof PlayerEntity)
			return false;
		if (source.getSource() instanceof PotionEntity || source.getSource() instanceof AreaEffectCloudEntity)
			return false;
		return super.damage(source, amount);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightPhantomHeadOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightPhantomHeadOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public void onPlayerCollision(PlayerEntity sourceentity) {
		super.onPlayerCollision(sourceentity);
		MidnightPhantomHeadPlayerCollidesWithThisEntityProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	protected void fall(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void tickMovement() {
		super.tickMovement();
		this.setNoGravity(true);
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_PHANTOM_HEAD, 12, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_PHANTOM_HEAD, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerFakerSpawnmainProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 2);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_FLYING_SPEED, 2);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.midnightlurkerphantomhead.idle"));
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
