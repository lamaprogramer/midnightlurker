package net.mcreator.midnightlurker.procedures;


import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;


public class ScreenShakeProcedure {
	public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
        IEntityDataSaver dataSaver = (IEntityDataSaver) entity;
		if (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("ScreenShake") > 0) {
				{
					double _setval = dataSaver.getPersistentData().getDouble("ScreenShake") - 1;
					dataSaver.getPersistentData().putDouble("ScreenShake", _setval);
					
				}
			}
		}
		if ((world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& dataSaver.getPersistentData().getDouble("ScreenShake") > 0) {
			{
				double _setval = 0;
				dataSaver.getPersistentData().putDouble("ScreenShake", _setval);
				
			}
		}
		if (!world.getEntitiesByClass(MidnightLurkerAggressiveEntity.class, Box.of(new Vec3d(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if (dataSaver.getPersistentData().getDouble("ScreenShake") > 0) {
				{
                    entity.setYaw(entity.getYaw() + MathHelper.nextInt(Random.create(), -1, 1));
					entity.setPitch(entity.getPitch() + MathHelper.nextInt(Random.create(), -1, 1));
					entity.setBodyYaw(entity.getYaw());
					entity.setHeadYaw(entity.getYaw());
					entity.prevYaw = entity.getYaw();
					entity.prevPitch = entity.getPitch();
					if (entity instanceof LivingEntity _entity) {
						_entity.prevBodyYaw = _entity.getYaw();
						_entity.prevHeadYaw = _entity.getYaw();
					}
				}
			}
		}
	}
}
