
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.*;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MidnightLurkerUnprovokedEntity extends HostileEntity implements GeoEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerUnprovokedEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerUnprovokedEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerUnprovokedEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public MidnightLurkerUnprovokedEntity(EntityType<MidnightLurkerUnprovokedEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
		setGlowing(true);
		setAiDisabled(false);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOT, false);
		this.dataTracker.startTracking(ANIMATION, "undefined");
		this.dataTracker.startTracking(TEXTURE, "midnightlurkervoidgate");
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
		this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(4, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && LurkerinwaterconditionProcedure.execute(entity);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && LurkerinwaterconditionProcedure.execute(entity);
			}
		});
		this.targetSelector.add(7, new ActiveTargetGoal(this, PigEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.add(8, new ActiveTargetGoal(this, CowEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.add(9, new ActiveTargetGoal(this, SheepEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.add(10, new ActiveTargetGoal(this, ChickenEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.canStart() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerUnprovokedEntity.this.getX();
				double y = MidnightLurkerUnprovokedEntity.this.getY();
				double z = MidnightLurkerUnprovokedEntity.this.getZ();
				Entity entity = MidnightLurkerUnprovokedEntity.this;
				World world = MidnightLurkerUnprovokedEntity.this.getWorld();
				return super.shouldContinue() && LurkerKillAnimalsProcProcedure.execute(world, x, y, z);
			}
		});
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
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
		if (!MidnightLurkerAggressiveEntityIsHurtProcedure.execute(this, source.getAttacker()))
			return false;
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
		MidnightLurkerEntityDiesProcedure.execute(this.getWorld(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason, @Nullable EntityData livingdata, @Nullable NbtCompound tag) {
		EntityData retval = super.initialize(world, difficulty, reason, livingdata, tag);
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

	@Override
	public EntityDimensions getDimensions(EntityPose p_33597_) {
		return super.getDimensions(p_33597_).scaled((float) 1);
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, 1, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_UNPROVOKED, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
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

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAttacking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking5"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim5"));
			}
			if (this.isSneaking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("backturned5"));
			}
			if (this.isAttacking() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("running56"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle5"));
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
			this.remove(MidnightLurkerUnprovokedEntity.RemovalReason.KILLED);
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
