package net.mcreator.midnightlurker.procedures;


import net.minecraft.entity.Entity;

public class InvisibleFootstepsPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getWorld().isClient())
			entity.discard();
	}
}
