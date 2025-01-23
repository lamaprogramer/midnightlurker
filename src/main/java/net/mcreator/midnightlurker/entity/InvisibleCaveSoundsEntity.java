
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.InvisibleFootstepsNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.FootstepsWalkToPlayerProcedure;
import net.mcreator.midnightlurker.procedures.VoidFloatProcProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class InvisibleCaveSoundsEntity extends HostileEntity implements GeoEntity, AnimatableEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(InvisibleCaveSoundsEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(InvisibleCaveSoundsEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(InvisibleCaveSoundsEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public InvisibleCaveSoundsEntity(EntityType<InvisibleCaveSoundsEntity> type, World world) {
		super(type, world);
		setGlowing(MidnightlurkerMod.DEBUG_MODE);
		setAiDisabled(false);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(SHOOT, false)
				.add(ANIMATION, "undefined")
				.add(TEXTURE, "nothing")
		);
	}

	public void setTexture(String texture) {
		this.dataTracker.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.dataTracker.get(TEXTURE);
	}

	@Override
	public double getEyeY() {
		return 1.4F;
	}

	

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.canStart() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.shouldContinue() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.add(2, new MeleeAttackGoal(this, 1, false) {
			@Override
			public boolean canStart() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.canStart() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.shouldContinue() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

		});
		this.goalSelector.add(3, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				return super.canStart() && VoidFloatProcProcedure.execute();
			}

			@Override
			public boolean shouldContinue() {
				return super.shouldContinue() && VoidFloatProcProcedure.execute();
			}
		});
		this.goalSelector.add(4, new WanderAroundGoal(this, 1) {
			@Override
			public boolean canStart() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.canStart() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean shouldContinue() {
				double x = InvisibleCaveSoundsEntity.this.getX();
				double y = InvisibleCaveSoundsEntity.this.getY();
				double z = InvisibleCaveSoundsEntity.this.getZ();
				World world = InvisibleCaveSoundsEntity.this.getWorld();
				return super.shouldContinue() && FootstepsWalkToPlayerProcedure.execute(world, x, y, z);
			}
		});
	}

    @Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:nostepsound")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of(""));
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
	public void baseTick() {
		super.baseTick();

		World world = this.getWorld();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 15)) {
			if (!this.getWorld().isClient()) {
				this.discard();
			}
		}

		IEntityDataSaver entityData = (IEntityDataSaver)this;
		if (entityData.getPersistentData().getDouble("CaveSoundTime") < 1200) {
			entityData.getPersistentData().putDouble("CaveSoundTime", (entityData.getPersistentData().getDouble("CaveSoundTime") + 1));
		}

		if (entityData.getPersistentData().getDouble("CaveSoundTime") == 1200) {
			entityData.getPersistentData().putDouble("CaveSoundTime", 0);
			if (Math.random() > 0.5) {
				SoundUtil.playsound(world, x, y, z, SoundEvents.AMBIENT_CAVE.value(), SoundCategory.AMBIENT, 50, (float) MathHelper.nextDouble(Random.create(), 0.2, 1));
			}
		}

		this.calculateDimensions();
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entity) {
	}

	@Override
	protected void tickCramming() {
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.INVISIBLE_CAVE_SOUNDS, 3, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.INVISIBLE_CAVE_SOUNDS, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return InvisibleFootstepsNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = PathAwareEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 5);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("gatewaydarkness"));
		}
		return PlayState.STOP;
	}

	private PlayState dynamicPredicate(AnimationState<?> animationState) {
		AnimationHandler animationHandler = (AnimationHandler) this;
		return animationHandler.dynamic(animationState, false);
	}

	@Override
	protected void updatePostDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(RemovalReason.KILLED);
			this.dropXp(null);
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
		data.add(new AnimationController<>(this, "procedure", 4, this::dynamicPredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
