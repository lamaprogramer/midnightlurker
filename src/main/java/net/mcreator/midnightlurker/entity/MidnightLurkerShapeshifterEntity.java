
package net.mcreator.midnightlurker.entity;

import net.minecraft.entity.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.minecraft.registry.Registries;



import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LongDoorInteractGoal;
import net.minecraft.entity.ai.goal.WanderAroundPointOfInterestGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;

import net.mcreator.midnightlurker.procedures.ShapeshiftermoveindoorsatnightProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerShapeshifterRightClickedOnEntityProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerShapeshifterOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerShapeshifterEntityIsHurtProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class MidnightLurkerShapeshifterEntity extends PathAwareEntity implements GeoEntity {
	public static final TrackedData<Boolean> SHOOT = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	public static final TrackedData<String> ANIMATION = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.STRING);
	public static final TrackedData<String> TEXTURE = DataTracker.registerData(MidnightLurkerShapeshifterEntity.class, TrackedDataHandlerRegistry.STRING);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	public MidnightLurkerShapeshifterEntity(EntityType<MidnightLurkerShapeshifterEntity> type, World world) {
		super(type, world);
		
		setGlowing(true);
		setAiDisabled(false);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOT, false);
		this.dataTracker.startTracking(ANIMATION, "undefined");
		this.dataTracker.startTracking(TEXTURE, "baseshapeshifter");
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
		this.goalSelector.add(1, new WanderAroundGoal(this, 1));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(3, new LongDoorInteractGoal(this, true));
		this.goalSelector.add(4, new LongDoorInteractGoal(this, false));
		this.goalSelector.add(5, new WanderAroundPointOfInterestGoal(this, 0.6, false) {
			@Override
			public boolean canStart() {
				double x = MidnightLurkerShapeshifterEntity.this.getX();
				double y = MidnightLurkerShapeshifterEntity.this.getY();
				double z = MidnightLurkerShapeshifterEntity.this.getZ();
				Entity entity = MidnightLurkerShapeshifterEntity.this;
				World world = MidnightLurkerShapeshifterEntity.this.getWorld();
				return super.canStart() && ShapeshiftermoveindoorsatnightProcedure.execute(world);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerShapeshifterEntity.this.getX();
				double y = MidnightLurkerShapeshifterEntity.this.getY();
				double z = MidnightLurkerShapeshifterEntity.this.getZ();
				Entity entity = MidnightLurkerShapeshifterEntity.this;
				World world = MidnightLurkerShapeshifterEntity.this.getWorld();
				return super.shouldContinue() && ShapeshiftermoveindoorsatnightProcedure.execute(world);
			}
		});
		this.goalSelector.add(6, new LookAroundGoal(this));
		this.goalSelector.add(7, new SwimGoal(this));
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return Registries.SOUND_EVENT.get(new Identifier("entity.villager.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(new Identifier("entity.villager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(new Identifier("entity.villager.death"));
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
		ItemStack itemstack = sourceentity.getStackInHand(hand);
		ActionResult retval = ActionResult.success(this.getWorld().isClient());
		super.interactMob(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
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
	public EntityDimensions getDimensions(EntityPose p_33597_) {
		return super.getDimensions(p_33597_).scaled((float) 1);
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		this.tickHandSwing();
	}

	public static void init() {
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER, 1, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_SHAPESHIFTER, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
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

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("shapeshifterwalk"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("shapeshifteridle"));
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
			this.remove(MidnightLurkerShapeshifterEntity.RemovalReason.KILLED);
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
