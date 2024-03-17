
package net.mcreator.midnightlurker.entity;

import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraft.registry.Registries;

import net.minecraft.block.BlockState;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveThisEntityKillsAnotherOneProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressivePlayReturnedAnimationProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveLoopExternalAnimationsProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveEntityDiesProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveBoundingBoxScaleProcedure;
import net.mcreator.midnightlurker.procedures.LurkerinwaterconditionProcedure;
import net.mcreator.midnightlurker.procedures.AggrowatchplayerProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class MidnightLurkerAggressiveEntity extends HostileEntity implements GeoEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerAggressiveEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerAggressiveEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerAggressiveEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public MidnightLurkerAggressiveEntity(EntityType<MidnightLurkerAggressiveEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
		setAiDisabled(false);
		setPersistent();
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOT, false);
		this.dataTracker.startTracking(ANIMATION, "undefined");
		this.dataTracker.startTracking(TEXTURE, "midnightlurkervoidgateangry");
	}

	public void setTexture(String texture) {
		this.dataTracker.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.dataTracker.get(TEXTURE);
	}

	@Override
	public Packet<ClientPlayPacketListener> createSpawnPacket() {
		return super.createSpawnPacket();
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.add(4, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerAggressiveEntity.this.getX();
				double y = MidnightLurkerAggressiveEntity.this.getY();
				double z = MidnightLurkerAggressiveEntity.this.getZ();
				Entity entity = MidnightLurkerAggressiveEntity.this;
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.canStart() && AggrowatchplayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerAggressiveEntity.this.getX();
				double y = MidnightLurkerAggressiveEntity.this.getY();
				double z = MidnightLurkerAggressiveEntity.this.getZ();
				Entity entity = MidnightLurkerAggressiveEntity.this;
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.shouldContinue() && AggrowatchplayerProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerAggressiveEntity.this.getX();
				double y = MidnightLurkerAggressiveEntity.this.getY();
				double z = MidnightLurkerAggressiveEntity.this.getZ();
				Entity entity = MidnightLurkerAggressiveEntity.this;
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.canStart() && LurkerinwaterconditionProcedure.execute(entity);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerAggressiveEntity.this.getX();
				double y = MidnightLurkerAggressiveEntity.this.getY();
				double z = MidnightLurkerAggressiveEntity.this.getZ();
				Entity entity = MidnightLurkerAggressiveEntity.this;
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.shouldContinue() && LurkerinwaterconditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	public boolean canImmediatelyDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerchasesteps")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerhurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(new Identifier("midnightlurker:lurkerdeath"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		MidnightLurkerAggressiveEntityIsHurtProcedure.execute(this, source.getAttacker());
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
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		MidnightLurkerAggressiveEntityDiesProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, @Nullable EntityData livingdata, @Nullable NbtCompound tag) {
		EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
		MidnightLurkerAggressiveOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void updateKilledAdvancementCriterion(Entity entity, int score, DamageSource damageSource) {
		super.updateKilledAdvancementCriterion(entity, score, damageSource);
		MidnightLurkerAggressiveThisEntityKillsAnotherOneProcedure.execute(this.getWorld(), entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerAggressiveOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public EntityDimensions getDimensions(EntityPose p_33597_) {
		Entity entity = this;
		World world = this.getWorld();
		double x = this.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return super.getDimensions(p_33597_).scaled((float) MidnightLurkerAggressiveBoundingBoxScaleProcedure.execute(world, x, y, z));
	}

	public static void init() {
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.42);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 120);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.7);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAttacking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking1"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim1"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running1"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle1"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		Entity entity = this;
		World world = entity.getWorld();
		boolean loop = false;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		String condition = MidnightLurkerAggressivePlayReturnedAnimationProcedure.execute(world, x, y, z, entity);
		if (!condition.equals("empty"))
			this.animationprocedure = condition;
		loop = MidnightLurkerAggressiveLoopExternalAnimationsProcedure.execute(world, x, y, z, entity);
		if (!loop && this.lastloop) {
			this.lastloop = false;
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			event.getController().forceAnimationReset();
			return PlayState.STOP;
		}
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			if (!loop) {
				event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
				if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
					this.animationprocedure = "empty";
					event.getController().forceAnimationReset();
				}
			} else {
				event.getController().setAnimation(RawAnimation.begin().thenLoop(this.animationprocedure));
				this.lastloop = true;
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void updatePostDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(MidnightLurkerAggressiveEntity.RemovalReason.KILLED);
			this.dropXp();
		}
	}

	public String getSyncedAnimation() {
		return this.dataTracker.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.dataTracker.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
