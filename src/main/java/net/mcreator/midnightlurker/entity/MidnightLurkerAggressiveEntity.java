
package net.mcreator.midnightlurker.entity;

import net.mcreator.midnightlurker.entity.hurt.MidnightLurkerAggressiveEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.init.MidnightLurkerAggressiveOnInitialEntitySpawnProcedure;
import net.mcreator.midnightlurker.entity.tick.MidnightLurkerAggressiveOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveBoundingBoxScaleProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveEntityDiesProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressiveLoopExternalAnimationsProcedure;
import net.mcreator.midnightlurker.procedures.MidnightLurkerAggressivePlayReturnedAnimationProcedure;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class MidnightLurkerAggressiveEntity extends MidnightLurkerEntity {
	public MidnightLurkerAggressiveEntity(EntityType<MidnightLurkerAggressiveEntity> type, World world) {
		super(type, world);
		this.experiencePoints = 25;
		setPersistent();
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkervoidgateangry")
		);
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
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.canStart() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}

			@Override
			public boolean shouldContinue() {
				double x = MidnightLurkerAggressiveEntity.this.getX();
				double y = MidnightLurkerAggressiveEntity.this.getY();
				double z = MidnightLurkerAggressiveEntity.this.getZ();
				World world = MidnightLurkerAggressiveEntity.this.getWorld();
				return super.shouldContinue() && EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 40);
			}
		});
		this.goalSelector.add(6, new SwimGoal(this) {
			@Override
			public boolean canStart() {
				Entity entity = MidnightLurkerAggressiveEntity.this;
				return super.canStart() && entity.isTouchingWater();
			}

			@Override
			public boolean shouldContinue() {
				Entity entity = MidnightLurkerAggressiveEntity.this;
				return super.shouldContinue() && entity.isTouchingWater();
			}
		});
	}

	@Override
	public boolean canImmediatelyDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerchasesteps")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerhurt"));
	}

	@Override
	public void onAttacking(Entity target) {
		World world = this.getEntityWorld();

		if (!world.isClient() && target instanceof PlayerEntity) {
			ServerWorld serverWorld = (ServerWorld) world;
			for (int index0 = 0; index0 < 50; index0++) {
				double posX = target.getX() + MathHelper.nextDouble(Random.create(), -6, 6);
				double posY = target.getY() + MathHelper.nextDouble(Random.create(), 0, 6);
				double posZ = target.getZ() + MathHelper.nextDouble(Random.create(), -6, 6);

				serverWorld.spawnParticles(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE, posX, posY, posZ, 1, 0d, 0d, 0d, 0d);
			}
		}

		super.onAttacking(target);
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdeath"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (!MidnightLurkerAggressiveEntityIsHurtProcedure.execute(this, source.getAttacker()))
			return false;
		return super.damage(source, amount);
	}

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		MidnightLurkerAggressiveEntityDiesProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
		EntityData retval = super.initialize(world, difficulty, spawnReason, entityData);
		MidnightLurkerAggressiveOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void updateKilledAdvancementCriterion(Entity entity, int score, DamageSource damageSource) {
		super.updateKilledAdvancementCriterion(entity, score, damageSource);
		World world = this.getWorld();

		if (world instanceof ServerWorld level) {
			level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/stopsound @a * midnightlurker:lurkerchase");
			level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/stopsound @a * midnightlurker:lurkerchase2");
			SoundUtil.playsound(world, entity.getX(), entity.getY(), entity.getZ(), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 1, 1);
		}

		if (!EntityUtil.hasNoEntityOfTypeInArea(world, MidnightLurkerAggressiveEntity.class, new Vec3d(entity.getX(), entity.getY(), entity.getZ()), 10)) {
			Entity entityInRange = EntityUtil.getPlayerEntityWithMinDistanceOf(world, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10);
			if (entityInRange != null && !entityInRange.getWorld().isClient()) {
				entityInRange.discard();
			}
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MidnightLurkerAggressiveOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
		this.calculateDimensions();
	}

	@Override
	public EntityDimensions getBaseDimensions(EntityPose p_33597_) {
		Entity entity = this;
		World world = this.getWorld();
		double x = this.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return super.getBaseDimensions(p_33597_).scaled((float) MidnightLurkerAggressiveBoundingBoxScaleProcedure.execute(world, x, y, z));
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

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && !this.isAttacking()) {
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

	@Override
	protected PlayState dynamicPredicate(AnimationState<?> animationState) {
		AnimationHandler animationHandler = (AnimationHandler) this;

		Entity entity = this;
		World world = entity.getWorld();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		String animationName = MidnightLurkerAggressivePlayReturnedAnimationProcedure.execute(world, x, y, z, this);
		boolean shouldLoop = MidnightLurkerAggressiveLoopExternalAnimationsProcedure.execute(world, x, y, z, this);

		return animationHandler.dynamic(animationState, animationName, shouldLoop);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
	}
}
