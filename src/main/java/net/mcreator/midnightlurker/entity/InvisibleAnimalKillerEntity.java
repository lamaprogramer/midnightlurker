
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.InvisibleFootstepsNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.InvisibleAnimalKillerOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class InvisibleAnimalKillerEntity extends HostileEntity implements GeoEntity, AnimatableEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(InvisibleAnimalKillerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(InvisibleAnimalKillerEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(InvisibleAnimalKillerEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public InvisibleAnimalKillerEntity(EntityType<InvisibleAnimalKillerEntity> type, World world) {
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
		this.targetSelector.add(1, new ActiveTargetGoal<>(this, PigEntity.class, false, false));
		this.targetSelector.add(2, new ActiveTargetGoal<>(this, CowEntity.class, false, false));
		this.targetSelector.add(3, new ActiveTargetGoal<>(this, SheepEntity.class, false, false));
		this.targetSelector.add(4, new ActiveTargetGoal<>(this, ChickenEntity.class, false, false));
		this.targetSelector.add(5, new MeleeAttackGoal(this, 1, false));
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				return super.canStart();
			}

			@Override
			public boolean shouldContinue() {
				return super.shouldContinue();
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
		InvisibleAnimalKillerOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entity) {}

	@Override
	protected void tickCramming() {}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.INVISIBLE_ANIMAL_KILLER, 4, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.INVISIBLE_ANIMAL_KILLER, SpawnLocationTypes.UNRESTRICTED, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return InvisibleFootstepsNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = PathAwareEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 40);
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
