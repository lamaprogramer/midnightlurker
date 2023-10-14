
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MidnightlurkerModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MidnightlurkerMod.MODID);
	public static final RegistryObject<EntityType<MidnightLurkerAggressiveEntity>> MIDNIGHT_LURKER_AGGRESSIVE = register("midnight_lurker_aggressive",
			EntityType.Builder.<MidnightLurkerAggressiveEntity>of(MidnightLurkerAggressiveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(MidnightLurkerAggressiveEntity::new).fireImmune().sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<MidnightLurkerEntity>> MIDNIGHT_LURKER = register("midnight_lurker", EntityType.Builder.<MidnightLurkerEntity>of(MidnightLurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MidnightLurkerEntity::new).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryObject<EntityType<MidnightLurkertposeEntity>> MIDNIGHT_LURKERTPOSE = register("midnight_lurkertpose", EntityType.Builder.<MidnightLurkertposeEntity>of(MidnightLurkertposeEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MidnightLurkertposeEntity::new).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryObject<EntityType<MidnightLurkerStalkingEntity>> MIDNIGHT_LURKER_STALKING = register("midnight_lurker_stalking",
			EntityType.Builder.<MidnightLurkerStalkingEntity>of(MidnightLurkerStalkingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(MidnightLurkerStalkingEntity::new).fireImmune().sized(0.7f, 2.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MidnightLurkerAggressiveEntity.init();
			MidnightLurkerEntity.init();
			MidnightLurkertposeEntity.init();
			MidnightLurkerStalkingEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MIDNIGHT_LURKER_AGGRESSIVE.get(), MidnightLurkerAggressiveEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER.get(), MidnightLurkerEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKERTPOSE.get(), MidnightLurkertposeEntity.createAttributes().build());
		event.put(MIDNIGHT_LURKER_STALKING.get(), MidnightLurkerStalkingEntity.createAttributes().build());
	}
}
