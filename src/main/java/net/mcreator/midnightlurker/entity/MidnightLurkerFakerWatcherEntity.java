
package net.mcreator.midnightlurker.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraft.registry.Registries;



import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.SpawnRestriction;
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

import net.mcreator.midnightlurker.procedures.MidnightLurkerOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerFakerWatcherOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerFakerWatcherNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerFakerWatcherEntityIsHurtProcedure;
import net.mcreator.midnightlurker.procedures.LurkerinwaterconditionProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

import org.jetbrains.annotations.Nullable;

public class MidnightLurkerFakerWatcherEntity extends HostileEntity implements GeoEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerFakerWatcherEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerFakerWatcherEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerFakerWatcherEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public MidnightLurkerFakerWatcherEntity(EntityType<MidnightLurkerFakerWatcherEntity> type, World world) {
		super(type, world);
		
		setAiDisabled(false);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOT, false);
		this.dataTracker.startTracking(ANIMATION, "undefined");
		this.dataTracker.startTracking(TEXTURE, "midnightlurker");
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
		this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(4, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerFakerWatcherEntity.this.getX();
				double y = MidnightLurkerFakerWatcherEntity.this.getY();
				double z = MidnightLurkerFakerWatcherEntity.this.getZ();
				Entity entity = MidnightLurkerFakerWatcherEntity.this;
				World world = MidnightLurkerFakerWatcherEntity.this.getWorld();
				return super.canStart() && LurkerinwaterconditionProcedure.execute(entity);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerFakerWatcherEntity.this.getX();
				double y = MidnightLurkerFakerWatcherEntity.this.getY();
				double z = MidnightLurkerFakerWatcherEntity.this.getZ();
				Entity entity = MidnightLurkerFakerWatcherEntity.this;
				World world = MidnightLurkerFakerWatcherEntity.this.getWorld();
				return super.shouldContinue() && LurkerinwaterconditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(new Identifier("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(new Identifier("entity.generic.death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		MidnightLurkerFakerWatcherEntityIsHurtProcedure.execute(this);
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
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, @Nullable EntityData livingdata, @Nullable NbtCompound tag) {
		EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
		MidnightLurkerOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerFakerWatcherOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public EntityDimensions getDimensions(EntityPose p_33597_) {
		return super.getDimensions(p_33597_).scaled((float) 1);
	}

	public static void init() {
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_FAKER_WATCHER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerFakerWatcherNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 200);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
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
			this.remove(MidnightLurkerFakerWatcherEntity.RemovalReason.KILLED);
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
