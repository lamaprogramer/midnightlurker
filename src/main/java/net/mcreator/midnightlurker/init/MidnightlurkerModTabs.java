
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;


public class MidnightlurkerModTabs {
	public static void buildTabContentsVanilla() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
			content.add(MidnightlurkerModItems.MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG_ITEM);
			content.add(MidnightlurkerModItems.MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG_ITEM);
			content.add(MidnightlurkerModItems.MIDNIGHT_LURKER_SHAPESHIFTER_SPAWN_EGG_ITEM);
		});
	}
}
