
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerHiderEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerHiderOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.procedures.MidnightLurkerEntityDiesProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerHiderBoundingBoxScaleProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class MidnightLurkerHiderEntity extends MidnightLurkerEntity {
	public MidnightLurkerHiderEntity(EntityType<MidnightLurkerHiderEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkervoidgate")
		);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false, false));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			public boolean canStart() {
				double x = MidnightLurkerHiderEntity.this.getX();
				double y = MidnightLurkerHiderEntity.this.getY();
				double z = MidnightLurkerHiderEntity.this.getZ();
				World world = MidnightLurkerHiderEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 8);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerHiderEntity.this.getX();
				double y = MidnightLurkerHiderEntity.this.getY();
				double z = MidnightLurkerHiderEntity.this.getZ();
				World world = MidnightLurkerHiderEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 8);
			}

		});
		this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, (float) 100));
		this.goalSelector.add(5, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightLurkerHiderEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightLurkerHiderEntity.this;
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
	public boolean damage(DamageSource source, float amount) {
		if (!MidnightLurkerHiderEntityIsHurtProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this, source.getAttacker()))
			return false;
		if (source.getSource() instanceof PersistentProjectileEntity)
			return false;
		if (source.getSource() instanceof PotionEntity || source.getSource() instanceof AreaEffectCloudEntity)
			return false;
		return super.damage(source, amount);
	}

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		MidnightLurkerEntityDiesProcedure.execute(this.getWorld(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void updateKilledAdvancementCriterion(Entity entity, int score, DamageSource damageSource) {
		super.updateKilledAdvancementCriterion(entity, score, damageSource);

		SoundUtil.playsound(this.getWorld(), entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!EntityUtil.hasNoEntityOfTypeInArea(this.getWorld(), MidnightLurkerHiderEntity.class, entity.getPos(), 10)) {
				if (!EntityUtil.getEntityWithMinDistanceOf(MidnightLurkerHiderEntity.class, this.getWorld(), new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).getWorld().isClient())
					EntityUtil.getEntityWithMinDistanceOf(MidnightLurkerHiderEntity.class, this.getWorld(), new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10).discard();
			}
		});
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerHiderOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public EntityDimensions getBaseDimensions(EntityPose p_33597_) {
		Entity entity = this;
		return super.getBaseDimensions(p_33597_).scaled((float) MidnightLurkerHiderBoundingBoxScaleProcedure.execute(entity));
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
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER, 8, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.MIDNIGHT_LURKER_HIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 60);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("stalking8"));
			}
			if (this.isInsideWaterOrBubbleColumn()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("swim8"));
			}
			if (this.isSneaking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("idlehidden8"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle8"));
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
