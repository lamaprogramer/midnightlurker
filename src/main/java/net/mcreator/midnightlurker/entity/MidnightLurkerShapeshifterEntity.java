
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerShapeshifterEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerShapeshifterOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.MidnightLurkerShapeshifterRightClickedOnEntityProcedure;
import net.mcreator.midnightlurker.procedures.ShapeshiftermoveindoorsatnightProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MidnightLurkerShapeshifterEntity extends PathAwareEntity implements GeoEntity, AnimatableEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public MidnightLurkerShapeshifterEntity(EntityType<MidnightLurkerShapeshifterEntity> type, World world) {
		super(type, world);
		
		setGlowing(MidnightlurkerMod.DEBUG_MODE);
		setAiDisabled(false);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(SHOOT, false)
				.add(ANIMATION, "undefined")
				.add(TEXTURE, "baseshapeshifter")
		);
	}

	public void setTexture(String texture) {
		this.dataTracker.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.dataTracker.get(TEXTURE);
	}

	

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new WanderAroundGoal(this, 1));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(3, new LongDoorInteractGoal(this, true));
		this.goalSelector.add(4, new LongDoorInteractGoal(this, false));
		this.goalSelector.add(5, new WanderAroundPointOfInterestGoal(this, 0.6, false) {
			@Override
			public boolean canStart() {
				World world = MidnightLurkerShapeshifterEntity.this.getWorld();
				return super.canStart() && ShapeshiftermoveindoorsatnightProcedure.execute(world);
			}

			@Override
			public boolean shouldContinue() {
				World world = MidnightLurkerShapeshifterEntity.this.getWorld();
				return super.shouldContinue() && ShapeshiftermoveindoorsatnightProcedure.execute(world);
			}
		});
		this.goalSelector.add(6, new LookAroundGoal(this));
		this.goalSelector.add(7, new SwimGoal(this));
	}

	

	@Override
	public SoundEvent getAmbientSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.villager.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.villager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.villager.death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		MidnightLurkerShapeshifterEntityIsHurtProcedure.execute(this.getWorld(), this);
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
	public ActionResult interactMob(PlayerEntity sourceentity, Hand hand) {
		ActionResult retval = ActionResult.success(this.getWorld().isClient());
		super.interactMob(sourceentity, hand);
		Entity entity = this;
		World world = this.getWorld();

		MidnightLurkerShapeshifterRightClickedOnEntityProcedure.execute(world, entity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerShapeshifterOnEntityTickUpdateProcedure.execute(this.getWorld(), this);
		this.calculateDimensions();
	}

	

	@Override
	public void tickMovement() {
		super.tickMovement();
		this.tickHandSwing();
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER, 7, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER, SpawnLocationTypes.UNRESTRICTED, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 200);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("shapeshifterwalk"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("shapeshifteridle"));
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
