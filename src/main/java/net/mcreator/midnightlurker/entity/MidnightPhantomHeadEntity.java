
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.*;
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
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class MidnightPhantomHeadEntity extends HostileEntity implements GeoEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightPhantomHeadEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightPhantomHeadEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightPhantomHeadEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public MidnightPhantomHeadEntity(EntityType<MidnightPhantomHeadEntity> type, World world) {
		super(type, world);
		
		setGlowing(MidnightlurkerMod.DEBUG_MODE);
		setAiDisabled(false);
		this.moveControl = new FlightMoveControl(this, 10, true);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(SHOOT, false)
				.add(ANIMATION, "undefined")
				.add(TEXTURE, "midnightlurkerphantomhead1")
		);
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
					double x = MidnightPhantomHeadEntity.this.getX();
					double y = MidnightPhantomHeadEntity.this.getY();
					double z = MidnightPhantomHeadEntity.this.getZ();
					Entity entity = MidnightPhantomHeadEntity.this;
					return PhantomheadwatchplayerProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightPhantomHeadEntity.this.getX();
				double y = MidnightPhantomHeadEntity.this.getY();
				double z = MidnightPhantomHeadEntity.this.getZ();
				Entity entity = MidnightPhantomHeadEntity.this;
				return PhantomheadwatchplayerProcedure.execute(entity) && MidnightPhantomHeadEntity.this.getMoveControl().isMoving() && MidnightPhantomHeadEntity.this.getTarget() != null && MidnightPhantomHeadEntity.this.getTarget().isAlive();
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
					double x = MidnightPhantomHeadEntity.this.getX();
					double y = MidnightPhantomHeadEntity.this.getY();
					double z = MidnightPhantomHeadEntity.this.getZ();
					Entity entity = MidnightPhantomHeadEntity.this;
					return PhantomheadattackplayerProcedure.execute(entity);
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
				double x = MidnightPhantomHeadEntity.this.getX();
				double y = MidnightPhantomHeadEntity.this.getY();
				double z = MidnightPhantomHeadEntity.this.getZ();
				Entity entity = MidnightPhantomHeadEntity.this;
				World world = MidnightPhantomHeadEntity.this.getWorld();
				return super.canStart() && LurkerinwaterconditionProcedure.execute(entity);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightPhantomHeadEntity.this.getX();
				double y = MidnightPhantomHeadEntity.this.getY();
				double z = MidnightPhantomHeadEntity.this.getZ();
				Entity entity = MidnightPhantomHeadEntity.this;
				World world = MidnightPhantomHeadEntity.this.getWorld();
				return super.shouldContinue() && LurkerinwaterconditionProcedure.execute(entity);
			}
		});
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
	public EntityDimensions getBaseDimensions(EntityPose p_33597_) {
		return super.getBaseDimensions(p_33597_).scaled((float) 1);
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

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.midnightlurkerphantomhead.idle"));
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
			this.remove(MidnightPhantomHeadEntity.RemovalReason.KILLED);
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
