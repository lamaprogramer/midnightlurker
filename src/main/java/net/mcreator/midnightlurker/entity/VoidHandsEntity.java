
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.MidnightLurkerNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.entity.tick.LurandsOnEntityTickUpdateProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.util.AnimationHandler;
import net.mcreator.midnightlurker.util.EntityUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.*;

public class VoidHandsEntity extends MidnightLurkerEntity {
	private boolean swinging;
	private long lastSwing;

	public VoidHandsEntity(EntityType<VoidHandsEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder
				.add(TEXTURE, "midnightlurkervoidgateshadowtrue")
		);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
		this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false, false) {
			@Override
			public boolean canStart() {
				double x = VoidHandsEntity.this.getX();
				double y = VoidHandsEntity.this.getY();
				double z = VoidHandsEntity.this.getZ();
				World world = VoidHandsEntity.this.getWorld();
				return super.canStart() && !EntityUtil.hasNoEntityOfTypeInArea(world, PlayerEntity.class, new Vec3d(x, y, z), 10);
			}
		});
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:nostepsound")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:voidhands_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:voidhands_death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		return super.damage(source, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		LurandsOnEntityTickUpdateProcedure.execute(this.getWorld(), this.getX(), this.getY(), this.getZ(), this);
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
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.VOID_HANDS, 6, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.VOID_HANDS, SpawnLocationTypes.UNRESTRICTED, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return MidnightLurkerNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 50);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32);
		builder = builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState<?> event) {
		if (!((AnimationHandler)this).hasAnimation()) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.lurands.chase"));
			}
			if (this.isSneaking()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.lurands.fakingidle"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.lurands.idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState<?> event) {
		if (getHandSwingProgress(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = getWorld().getTime();
		}
		if (this.swinging && this.lastSwing + 7L <= getWorld().getTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("animation.lurands.attack"));
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		super.registerControllers(data);
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
	}
}
