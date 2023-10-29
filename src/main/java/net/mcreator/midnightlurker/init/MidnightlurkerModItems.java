
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MidnightlurkerMod.MODID);
	public static final RegistryObject<Item> MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG = REGISTRY.register("midnight_lurker_aggressive_spawn_egg",
			() -> new ForgeSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE, -13421773, -3355444, new Item.Properties()));
	public static final RegistryObject<Item> MIDNIGHT_LURKER_SPAWN_EGG = REGISTRY.register("midnight_lurker_spawn_egg", () -> new ForgeSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER, -13421773, -3355444, new Item.Properties()));
	public static final RegistryObject<Item> MIDNIGHT_LURKERTPOSE_SPAWN_EGG = REGISTRY.register("midnight_lurkertpose_spawn_egg",
			() -> new ForgeSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKERTPOSE, -13421773, -3355444, new Item.Properties()));
	public static final RegistryObject<Item> MIDNIGHT_LURKER_STALKING_SPAWN_EGG = REGISTRY.register("midnight_lurker_stalking_spawn_egg",
			() -> new ForgeSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_STALKING, -13421773, -3355444, new Item.Properties()));
	public static final RegistryObject<Item> MIDNIGHT_LURKER_NE_SPAWN_EGG = REGISTRY.register("midnight_lurker_ne_spawn_egg", () -> new ForgeSpawnEggItem(MidnightlurkerModEntities.MIDNIGHT_LURKER_NE, -13421773, -3355444, new Item.Properties()));
}
