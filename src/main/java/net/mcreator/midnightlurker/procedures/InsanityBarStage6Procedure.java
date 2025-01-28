package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.mcreator.midnightlurker.util.SoundUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.WorldAccess;

public class InsanityBarStage6Procedure {
	public static boolean execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		CoreConfig config = MidnightlurkerMod.CONFIG;

		if (config.shouldHaveInsanityBar()) {
			SoundUtil.playsound(world, x, y, z, SoundEvent.of(Identifier.of("midnightlurker:lurkerdisappear")), SoundCategory.NEUTRAL, 0, 0);
		}

		if (config.shouldHaveInsanityBar()) {
			return ((IEntityDataSaver) entity).getPersistentData().getDouble("InsanityStage") == 6;
		}
		return false;
	}
}
