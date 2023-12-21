
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MidnightlurkerModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MidnightlurkerModItems.MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG.get());
			tabData.accept(MidnightlurkerModItems.MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG.get());
			tabData.accept(MidnightlurkerModItems.MIDNIGHT_LURKER_SHAPESHIFTER_SPAWN_EGG.get());
		}
	}
}
