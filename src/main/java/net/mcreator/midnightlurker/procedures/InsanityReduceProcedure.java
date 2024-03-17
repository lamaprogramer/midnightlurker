package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.util.IEntityDataSaver;

import net.minecraft.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.util.IEntityDataSaver;

import org.jetbrains.annotations.Nullable;

import java.io.File;


//public class InsanityReduceProcedure {
//
//	public static void onPlayerFishItem(ItemFishedEvent event) {
//		execute(event, event.getEntity());
//	}
//
//	public static void execute(Entity entity) {
//		execute(null, entity);
//	}
//
//	private static void execute(@Nullable Event event, Entity entity) {
//		if (entity == null)
//			return;
//		File lurker = new File("");
//		if (((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") < 7) {
//			if (((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") >= 400) {
//				{
//					double _setval = ((IEntityDataSaver)entity).getPersistentData().getDouble("InsanityTimer") - 200;
//					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
//						dataSaver.getPersistentData().putDouble("InsanityTimer", _setval);
//						capability.syncPlayerVariables(entity);
//					});
//				}
//			}
//		}
//	}
//}
