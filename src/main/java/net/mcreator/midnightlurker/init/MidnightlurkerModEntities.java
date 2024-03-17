
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.entity.SpookyambienceentityEntity;
import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;
import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightPhantomHeadEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;
import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;
import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;
import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;
import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.entity.Destroytex2Entity;

public class MidnightlurkerModEntities {
	public static EntityType<MidnightLurkerAggressiveEntity> MIDNIGHT_LURKER_AGGRESSIVE = register(new Identifier("midnightlurker", "midnight_lurker_aggressive"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerAggressiveEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerAggressiveEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkertposeEntity> MIDNIGHT_LURKERTPOSE = register(new Identifier("midnightlurker", "midnight_lurkertpose"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkertposeEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkertposeEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerStalkingEntity> MIDNIGHT_LURKER_STALKING = register(new Identifier("midnightlurker", "midnight_lurker_stalking"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerStalkingEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerStalkingEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerInvisibleEntity> MIDNIGHT_LURKER_INVISIBLE = register(new Identifier("midnightlurker", "midnight_lurker_invisible"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerInvisibleEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerInvisibleEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<SpookyambienceentityEntity> SPOOKYAMBIENCEENTITY = register(new Identifier("midnightlurker", "spookyambienceentity"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpookyambienceentityEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(SpookyambienceentityEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerSeenAngressiveEntity> MIDNIGHT_LURKER_SEEN_ANGRESSIVE = register(new Identifier("midnightlurker", "midnight_lurker_seen_angressive"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerSeenAngressiveEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerSeenAngressiveEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<DestroytexEntity> DESTROYTEX = register(new Identifier("midnightlurker", "destroytex"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DestroytexEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64)
			.trackedUpdateRate(3).entityFactory(DestroytexEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 3f)).build());
	public static EntityType<Destroytex2Entity> DESTROYTEX_2 = register(new Identifier("midnightlurker", "destroytex_2"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Destroytex2Entity::new).forceTrackedVelocityUpdates(true)
			.trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(Destroytex2Entity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 3f)).build());
	public static EntityType<Destroytex3Entity> DESTROYTEX_3 = register(new Identifier("midnightlurker", "destroytex_3"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Destroytex3Entity::new).forceTrackedVelocityUpdates(true)
			.trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(Destroytex3Entity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 3f)).build());
	public static EntityType<Destroytex4Entity> DESTROYTEX_4 = register(new Identifier("midnightlurker", "destroytex_4"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Destroytex4Entity::new).forceTrackedVelocityUpdates(true)
			.trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(Destroytex4Entity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 3f)).build());
	public static EntityType<MidnightLurkerFakerAggroEntity> MIDNIGHT_LURKER_FAKER_AGGRO = register(new Identifier("midnightlurker", "midnight_lurker_faker_aggro"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerFakerAggroEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerFakerAggroEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerFakerEntity> MIDNIGHT_LURKER_FAKER = register(new Identifier("midnightlurker", "midnight_lurker_faker"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerFakerEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerFakerEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerFakerWatcherEntity> MIDNIGHT_LURKER_FAKER_WATCHER = register(new Identifier("midnightlurker", "midnight_lurker_faker_watcher"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerFakerWatcherEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerFakerWatcherEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<VoidGatewayEntity> VOID_GATEWAY = register(new Identifier("midnightlurker", "void_gateway"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VoidGatewayEntity::new).forceTrackedVelocityUpdates(true)
			.trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(VoidGatewayEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6f, 1.4f)).build());
	public static EntityType<MidnightLurkerBackturnedEntity> MIDNIGHT_LURKER_BACKTURNED = register(new Identifier("midnightlurker", "midnight_lurker_backturned"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerBackturnedEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerBackturnedEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerShadowEyesEntity> MIDNIGHT_LURKER_SHADOW_EYES = register(new Identifier("midnightlurker", "midnight_lurker_shadow_eyes"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerShadowEyesEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerShadowEyesEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerShadowEntity> MIDNIGHT_LURKER_SHADOW = register(new Identifier("midnightlurker", "midnight_lurker_shadow"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerShadowEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerShadowEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerUnprovokedEntity> MIDNIGHT_LURKER_UNPROVOKED = register(new Identifier("midnightlurker", "midnight_lurker_unprovoked"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerUnprovokedEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerUnprovokedEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerRunawayEntity> MIDNIGHT_LURKER_RUNAWAY = register(new Identifier("midnightlurker", "midnight_lurker_runaway"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerRunawayEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerRunawayEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerRuntrueEntity> MIDNIGHT_LURKER_RUNTRUE = register(new Identifier("midnightlurker", "midnight_lurker_runtrue"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerRuntrueEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerRuntrueEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerHiderEntity> MIDNIGHT_LURKER_HIDER = register(new Identifier("midnightlurker", "midnight_lurker_hider"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerHiderEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerHiderEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerShapeshifterEntity> MIDNIGHT_LURKER_SHAPESHIFTER = register(new Identifier("midnightlurker", "midnight_lurker_shapeshifter"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerShapeshifterEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(MidnightLurkerShapeshifterEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
	public static EntityType<MidnightLurkerStareEntity> MIDNIGHT_LURKER_STARE = register(new Identifier("midnightlurker", "midnight_lurker_stare"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerStareEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerStareEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightlurkerNEEntity> MIDNIGHTLURKER_NE = register(new Identifier("midnightlurker", "midnightlurker_ne"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightlurkerNEEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightlurkerNEEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightLurkerWatcherEntity> MIDNIGHT_LURKER_WATCHER = register(new Identifier("midnightlurker", "midnight_lurker_watcher"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerWatcherEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerWatcherEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<VoidHandsEntity> VOID_HANDS = register(new Identifier("midnightlurker", "void_hands"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VoidHandsEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64)
			.trackedUpdateRate(3).entityFactory(VoidHandsEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6f, 1.4f)).build());
	public static EntityType<InvisibleFootstepsEntity> INVISIBLE_FOOTSTEPS = register(new Identifier("midnightlurker", "invisible_footsteps"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InvisibleFootstepsEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(InvisibleFootstepsEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<InvisibleShadowEntity> INVISIBLE_SHADOW = register(new Identifier("midnightlurker", "invisible_shadow"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InvisibleShadowEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(InvisibleShadowEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<InvisibleStaticEntity> INVISIBLE_STATIC = register(new Identifier("midnightlurker", "invisible_static"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InvisibleStaticEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(InvisibleStaticEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<InvisibleLurkerFootstepsEntity> INVISIBLE_LURKER_FOOTSTEPS = register(new Identifier("midnightlurker", "invisible_lurker_footsteps"),
			FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, InvisibleLurkerFootstepsEntity::new).forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3)
					.entityFactory(InvisibleLurkerFootstepsEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<InvisibleCaveSoundsEntity> INVISIBLE_CAVE_SOUNDS = register(new Identifier("midnightlurker", "invisible_cave_sounds"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InvisibleCaveSoundsEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(InvisibleCaveSoundsEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<MidnightLurkerCreepEntity> MIDNIGHT_LURKER_CREEP = register(new Identifier("midnightlurker", "midnight_lurker_creep"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightLurkerCreepEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightLurkerCreepEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.7f, 2.5f)).build());
	public static EntityType<MidnightPhantomHeadEntity> MIDNIGHT_PHANTOM_HEAD = register(new Identifier("midnightlurker", "midnight_phantom_head"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MidnightPhantomHeadEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(MidnightPhantomHeadEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.4f, 0.5f)).build());
	public static EntityType<InvisibleAnimalKillerEntity> INVISIBLE_ANIMAL_KILLER = register(new Identifier("midnightlurker", "invisible_animal_killer"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InvisibleAnimalKillerEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(InvisibleAnimalKillerEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());
	public static EntityType<ShapeshifterPigEntity> SHAPESHIFTER_PIG = register(new Identifier("midnightlurker", "shapeshifter_pig"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShapeshifterPigEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(ShapeshifterPigEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());
	public static EntityType<ShapeShifterCowEntity> SHAPE_SHIFTER_COW = register(new Identifier("midnightlurker", "shape_shifter_cow"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShapeShifterCowEntity::new)
			.forceTrackedVelocityUpdates(true).trackRangeBlocks(64).trackedUpdateRate(3).entityFactory(ShapeShifterCowEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.9f, 1.4f)).build());

	private static <T extends Entity> EntityType<T> register(Identifier id, EntityType<T> typeBuilder) {
		return Registry.register(Registries.ENTITY_TYPE, id, typeBuilder);
	}
	public static void init() {
		MidnightLurkerAggressiveEntity.init();
		MidnightLurkertposeEntity.init();
		MidnightLurkerStalkingEntity.init();
		MidnightLurkerInvisibleEntity.init();
		SpookyambienceentityEntity.init();
		MidnightLurkerSeenAngressiveEntity.init();
		DestroytexEntity.init();
		Destroytex2Entity.init();
		Destroytex3Entity.init();
		Destroytex4Entity.init();
		MidnightLurkerFakerAggroEntity.init();
		MidnightLurkerFakerEntity.init();
		MidnightLurkerFakerWatcherEntity.init();
		VoidGatewayEntity.init();
		MidnightLurkerBackturnedEntity.init();
		MidnightLurkerShadowEyesEntity.init();
		MidnightLurkerShadowEntity.init();
		MidnightLurkerUnprovokedEntity.init();
		MidnightLurkerRunawayEntity.init();
		MidnightLurkerRuntrueEntity.init();
		MidnightLurkerHiderEntity.init();
		MidnightLurkerShapeshifterEntity.init();
		MidnightLurkerStareEntity.init();
		MidnightlurkerNEEntity.init();
		MidnightLurkerWatcherEntity.init();
		VoidHandsEntity.init();
		InvisibleFootstepsEntity.init();
		InvisibleShadowEntity.init();
		InvisibleStaticEntity.init();
		InvisibleLurkerFootstepsEntity.init();
		InvisibleCaveSoundsEntity.init();
		MidnightLurkerCreepEntity.init();
		MidnightPhantomHeadEntity.init();
		InvisibleAnimalKillerEntity.init();
		ShapeshifterPigEntity.init();
		ShapeShifterCowEntity.init();

		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_AGGRESSIVE, MidnightLurkerAggressiveEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKERTPOSE, MidnightLurkertposeEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_STALKING, MidnightLurkerStalkingEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_INVISIBLE, MidnightLurkerInvisibleEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(SPOOKYAMBIENCEENTITY, SpookyambienceentityEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SEEN_ANGRESSIVE, MidnightLurkerSeenAngressiveEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(DESTROYTEX, DestroytexEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(DESTROYTEX_2, Destroytex2Entity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(DESTROYTEX_3, Destroytex3Entity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(DESTROYTEX_4, Destroytex4Entity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER_AGGRO, MidnightLurkerFakerAggroEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER, MidnightLurkerFakerEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER_WATCHER, MidnightLurkerFakerWatcherEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(VOID_GATEWAY, VoidGatewayEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_BACKTURNED, MidnightLurkerBackturnedEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHADOW_EYES, MidnightLurkerShadowEyesEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHADOW, MidnightLurkerShadowEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_UNPROVOKED, MidnightLurkerUnprovokedEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_RUNAWAY, MidnightLurkerRunawayEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_RUNTRUE, MidnightLurkerRuntrueEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_HIDER, MidnightLurkerHiderEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHAPESHIFTER, MidnightLurkerShapeshifterEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_STARE, MidnightLurkerStareEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHTLURKER_NE, MidnightlurkerNEEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_WATCHER, MidnightLurkerWatcherEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(VOID_HANDS, VoidHandsEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_FOOTSTEPS, InvisibleFootstepsEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_SHADOW, InvisibleShadowEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_STATIC, InvisibleStaticEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_LURKER_FOOTSTEPS, InvisibleLurkerFootstepsEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_CAVE_SOUNDS, InvisibleCaveSoundsEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_CREEP, MidnightLurkerCreepEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_PHANTOM_HEAD, MidnightPhantomHeadEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(INVISIBLE_ANIMAL_KILLER, InvisibleAnimalKillerEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(SHAPESHIFTER_PIG, ShapeshifterPigEntity.createAttributes().build());
		FabricDefaultAttributeRegistry.register(SHAPE_SHIFTER_COW, ShapeShifterCowEntity.createAttributes().build());
	}
}
