
package net.mcreator.midnightlurker.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.entity.hurt.ShapeshifterPigEntityIsHurtProcedure;
import net.mcreator.midnightlurker.entity.spawnconditions.natural.ShapeshifterPigNaturalEntitySpawningConditionProcedure;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;

public class ShapeshifterPigEntity extends PathAwareEntity {

	public ShapeshifterPigEntity(EntityType<ShapeshifterPigEntity> type, World world) {
		super(type, world);
		setGlowing(MidnightlurkerMod.DEBUG_MODE);
		setAiDisabled(false);
	}

	@Override
	public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
		return super.createSpawnPacket(entityTrackerEntry);
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
	public SoundEvent getAmbientSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.pig.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(Registries.SOUND_EVENT.get(Identifier.of("entity.pig.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.pig.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return Registries.SOUND_EVENT.get(Identifier.of("entity.pig.death"));
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
		BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, MidnightlurkerModEntities.SHAPESHIFTER_PIG, 8, 1, 1);
		SpawnRestriction.register(MidnightlurkerModEntities.SHAPESHIFTER_PIG, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
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
