
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mcreator.midnightlurker.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MidnightlurkerModEntities {
	public static EntityType<MidnightLurkerAggressiveEntity> MIDNIGHT_LURKER_AGGRESSIVE = register(Identifier.of("midnightlurker", "midnight_lurker_aggressive"),
			EntityType.Builder.create(MidnightLurkerAggressiveEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkertposeEntity> MIDNIGHT_LURKERTPOSE = register(Identifier.of("midnightlurker", "midnight_lurkertpose"), EntityType.Builder.create(MidnightLurkertposeEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerStalkingEntity> MIDNIGHT_LURKER_STALKING = register(Identifier.of("midnightlurker", "midnight_lurker_stalking"),
			EntityType.Builder.create(MidnightLurkerStalkingEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerInvisibleEntity> MIDNIGHT_LURKER_INVISIBLE = register(Identifier.of("midnightlurker", "midnight_lurker_invisible"),
			EntityType.Builder.create(MidnightLurkerInvisibleEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<SpookyambienceentityEntity> SPOOKYAMBIENCEENTITY = register(Identifier.of("midnightlurker", "spookyambienceentity"), EntityType.Builder.create(SpookyambienceentityEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerSeenAngressiveEntity> MIDNIGHT_LURKER_SEEN_ANGRESSIVE = register(Identifier.of("midnightlurker", "midnight_lurker_seen_angressive"),
			EntityType.Builder.create(MidnightLurkerSeenAngressiveEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerFakerAggroEntity> MIDNIGHT_LURKER_FAKER_AGGRO = register(Identifier.of("midnightlurker", "midnight_lurker_faker_aggro"),
			EntityType.Builder.create(MidnightLurkerFakerAggroEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerFakerEntity> MIDNIGHT_LURKER_FAKER = register(Identifier.of("midnightlurker", "midnight_lurker_faker"), EntityType.Builder.create(MidnightLurkerFakerEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerFakerWatcherEntity> MIDNIGHT_LURKER_FAKER_WATCHER = register(Identifier.of("midnightlurker", "midnight_lurker_faker_watcher"),
			EntityType.Builder.create(MidnightLurkerFakerWatcherEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<VoidGatewayEntity> VOID_GATEWAY = register(Identifier.of("midnightlurker", "void_gateway"), EntityType.Builder.create(VoidGatewayEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true)
			.maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.6f, 1.4f).build());
	
	public static EntityType<MidnightLurkerBackturnedEntity> MIDNIGHT_LURKER_BACKTURNED = register(Identifier.of("midnightlurker", "midnight_lurker_backturned"),
			EntityType.Builder.create(MidnightLurkerBackturnedEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerShadowEyesEntity> MIDNIGHT_LURKER_SHADOW_EYES = register(Identifier.of("midnightlurker", "midnight_lurker_shadow_eyes"),
			EntityType.Builder.create(MidnightLurkerShadowEyesEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerShadowEntity> MIDNIGHT_LURKER_SHADOW = register(Identifier.of("midnightlurker", "midnight_lurker_shadow"), EntityType.Builder.create(MidnightLurkerShadowEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerUnprovokedEntity> MIDNIGHT_LURKER_UNPROVOKED = register(Identifier.of("midnightlurker", "midnight_lurker_unprovoked"),
			EntityType.Builder.create(MidnightLurkerUnprovokedEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerRunawayEntity> MIDNIGHT_LURKER_RUNAWAY = register(Identifier.of("midnightlurker", "midnight_lurker_runaway"), EntityType.Builder.create(MidnightLurkerRunawayEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerRuntrueEntity> MIDNIGHT_LURKER_RUNTRUE = register(Identifier.of("midnightlurker", "midnight_lurker_runtrue"), EntityType.Builder.create(MidnightLurkerRuntrueEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerHiderEntity> MIDNIGHT_LURKER_HIDER = register(Identifier.of("midnightlurker", "midnight_lurker_hider"), EntityType.Builder.create(MidnightLurkerHiderEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerShapeshifterEntity> MIDNIGHT_LURKER_SHAPESHIFTER = register(Identifier.of("midnightlurker", "midnight_lurker_shapeshifter"),
			EntityType.Builder.create(MidnightLurkerShapeshifterEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.6f, 1.95f).build());
	
	public static EntityType<MidnightLurkerStareEntity> MIDNIGHT_LURKER_STARE = register(Identifier.of("midnightlurker", "midnight_lurker_stare"), EntityType.Builder.create(MidnightLurkerStareEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightlurkerNEEntity> MIDNIGHTLURKER_NE = register(Identifier.of("midnightlurker", "midnightlurker_ne"), EntityType.Builder.create(MidnightlurkerNEEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightLurkerWatcherEntity> MIDNIGHT_LURKER_WATCHER = register(Identifier.of("midnightlurker", "midnight_lurker_watcher"), EntityType.Builder.create(MidnightLurkerWatcherEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<VoidHandsEntity> VOID_HANDS = register(Identifier.of("midnightlurker", "void_hands"), EntityType.Builder.create(VoidHandsEntity::new, SpawnGroup.MONSTER).alwaysUpdateVelocity(true).maxTrackingRange(64)
			.trackingTickInterval(3).makeFireImmune().dimensions(0.6f, 1.4f).build());
	
	public static EntityType<InvisibleFootstepsEntity> INVISIBLE_FOOTSTEPS = register(Identifier.of("midnightlurker", "invisible_footsteps"), EntityType.Builder.create(InvisibleFootstepsEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<InvisibleShadowEntity> INVISIBLE_SHADOW = register(Identifier.of("midnightlurker", "invisible_shadow"), EntityType.Builder.create(InvisibleShadowEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<InvisibleStaticEntity> INVISIBLE_STATIC = register(Identifier.of("midnightlurker", "invisible_static"), EntityType.Builder.create(InvisibleStaticEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<InvisibleLurkerFootstepsEntity> INVISIBLE_LURKER_FOOTSTEPS = register(Identifier.of("midnightlurker", "invisible_lurker_footsteps"),
			EntityType.Builder.create(InvisibleLurkerFootstepsEntity::new, SpawnGroup.AMBIENT).alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3)
					.makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<InvisibleCaveSoundsEntity> INVISIBLE_CAVE_SOUNDS = register(Identifier.of("midnightlurker", "invisible_cave_sounds"), EntityType.Builder.create(InvisibleCaveSoundsEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<MidnightLurkerCreepEntity> MIDNIGHT_LURKER_CREEP = register(Identifier.of("midnightlurker", "midnight_lurker_creep"), EntityType.Builder.create(MidnightLurkerCreepEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.7f, 2.5f).build());
	
	public static EntityType<MidnightPhantomHeadEntity> MIDNIGHT_PHANTOM_HEAD = register(Identifier.of("midnightlurker", "midnight_phantom_head"), EntityType.Builder.create(MidnightPhantomHeadEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.4f, 0.5f).build());
	
	public static EntityType<InvisibleAnimalKillerEntity> INVISIBLE_ANIMAL_KILLER = register(Identifier.of("midnightlurker", "invisible_animal_killer"), EntityType.Builder.create(InvisibleAnimalKillerEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.5f, 0.4f).build());
	
	public static EntityType<ShapeshifterPigEntity> SHAPESHIFTER_PIG = register(Identifier.of("midnightlurker", "shapeshifter_pig"), EntityType.Builder.create(ShapeshifterPigEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.9f, 0.9f).build());
	
	public static EntityType<ShapeShifterCowEntity> SHAPE_SHIFTER_COW = register(Identifier.of("midnightlurker", "shape_shifter_cow"), EntityType.Builder.create(ShapeShifterCowEntity::new, SpawnGroup.MONSTER)
			.alwaysUpdateVelocity(true).maxTrackingRange(64).trackingTickInterval(3).makeFireImmune().dimensions(0.9f, 1.4f).build());

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

		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_AGGRESSIVE, MidnightLurkerAggressiveEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKERTPOSE, MidnightLurkertposeEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_STALKING, MidnightLurkerStalkingEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_INVISIBLE, MidnightLurkerInvisibleEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(SPOOKYAMBIENCEENTITY, SpookyambienceentityEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SEEN_ANGRESSIVE, MidnightLurkerSeenAngressiveEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER_AGGRO, MidnightLurkerFakerAggroEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER, MidnightLurkerFakerEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_FAKER_WATCHER, MidnightLurkerFakerWatcherEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(VOID_GATEWAY, VoidGatewayEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_BACKTURNED, MidnightLurkerBackturnedEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHADOW_EYES, MidnightLurkerShadowEyesEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHADOW, MidnightLurkerShadowEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_UNPROVOKED, MidnightLurkerUnprovokedEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_RUNAWAY, MidnightLurkerRunawayEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_RUNTRUE, MidnightLurkerRuntrueEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_HIDER, MidnightLurkerHiderEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_SHAPESHIFTER, MidnightLurkerShapeshifterEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_STARE, MidnightLurkerStareEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHTLURKER_NE, MidnightlurkerNEEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_WATCHER, MidnightLurkerWatcherEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(VOID_HANDS, VoidHandsEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_FOOTSTEPS, InvisibleFootstepsEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_SHADOW, InvisibleShadowEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_STATIC, InvisibleStaticEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_LURKER_FOOTSTEPS, InvisibleLurkerFootstepsEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_CAVE_SOUNDS, InvisibleCaveSoundsEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_LURKER_CREEP, MidnightLurkerCreepEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(MIDNIGHT_PHANTOM_HEAD, MidnightPhantomHeadEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(INVISIBLE_ANIMAL_KILLER, InvisibleAnimalKillerEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(SHAPESHIFTER_PIG, ShapeshifterPigEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(SHAPE_SHIFTER_COW, ShapeShifterCowEntity.createAttributes());
	}
}
