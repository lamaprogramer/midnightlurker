
package net.mcreator.midnightlurker.entity;

import net.minecraft.registry.Registries;



import net.minecraft.world.Heightmap;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.BlockPos;

import net.mcreator.midnightlurker.procedures.ShapeshifterPigNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.procedures.ShapeshifterPigEntityIsHurtProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;

public class ShapeshifterPigEntity extends PathAwareEntity {

	public ShapeshifterPigEntity(EntityType<ShapeshifterPigEntity> type, World world) {
		super(type, world);
		setStepHeight(0.6f);
		
		setAiDisabled(false);
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
		this.goalSelector.add(3, new LookAroundGoal(this));
		this.goalSelector.add(4, new SwimGoal(this));
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return Registries.SOUND_EVENT.get(new Identifier("entity.pig.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(new Identifier("entity.pig.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(new Identifier("entity.pig.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(new Identifier("entity.pig.death"));
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		ShapeshifterPigEntityIsHurtProcedure.execute(this.getWorld(), this);
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

	public static void init() {
		SpawnRestriction.register(MidnightlurkerModEntities.SHAPESHIFTER_PIG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ShapeshifterPigNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes();
		builder = builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
		builder = builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 30);
		builder = builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder = builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		builder = builder.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16);
		return builder;
	}
}
