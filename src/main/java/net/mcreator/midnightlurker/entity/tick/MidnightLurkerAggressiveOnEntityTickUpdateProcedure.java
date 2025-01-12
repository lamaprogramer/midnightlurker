package net.mcreator.midnightlurker.entity.tick;

import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldAccess;

public class MidnightLurkerAggressiveOnEntityTickUpdateProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		
		IEntityDataSaver entityData = (IEntityDataSaver) entity;

		EntityTickActions.handleBreakDoors(world, x, y, z);
		EntityTickActions.handleFasterSwimSpeed(world, entity, x, y, z);
		EntityTickActions.handleAutoDismount(entity);
		EntityTickActions.handleClimbing(world, entity, x, y, z);
		EntityTickActions.handleBlockBreaking(world, entity, entityData, x, y, z);
		EntityTickActions.handleSpeedWhenObstructed(world, entity, x, y, z);
		EntityTickActions.handleParticles(0.9, world, MidnightlurkerModParticleTypes.VOID_DOT, x, y, z, 2, 0.3, 1.2, 0.3, 0.1);
		EntityTickActions.handleGlassBreaking(world, x, y, z);
		EntityTickActions.handleLurkerScream(world, entity, entityData);
		EntityTickActions.handleLurkerChase(world, entity, entityData, x, y, z);
		EntityTickActions.handleDamageScaling(world, entity, x, y, z);
	}
}
