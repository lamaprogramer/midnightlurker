package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.config.CoreConfig;
import net.mcreator.midnightlurker.entity.tick.util.EntityTickActions;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class JumpscareTimerProcedure {
    public static boolean execute(WorldAccess world, double x, double y, double z, LivingEntity entity) {
		if (entity == null)
			return false;

		CoreConfig config = MidnightlurkerMod.CONFIG;
		IEntityDataSaver dataSaver = (IEntityDataSaver) entity; 
		
		boolean doJumpscareSound = config.shouldDoJumpscareSound();
		boolean doPopupJumpscare = config.shouldDoPopUpJumpscare();
		
		if (doJumpscareSound) {
			if (dataSaver.getPersistentData().getDouble("JumpscareTimer") == 31
					&& dataSaver.getPersistentData().getDouble("JumpscareActive") > 0) {
				if (world instanceof ServerWorld level)
					level.getServer().getCommandManager().executeWithPrefix(new ServerCommandSource(CommandOutput.DUMMY, new Vec3d((entity.getX()), (entity.getY()), (entity.getZ())), Vec2f.ZERO, level, 4, "", Text.literal(""), level.getServer(), null).withSilent(), "/playsound midnightlurker:lurkerjumpscare neutral @p");
			}
		}
		
		if (doPopupJumpscare) {
			if (world instanceof World level) {
				if (!level.isClient()) {
					level.playSound(null, BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0);
				} else {
					level.playSoundAtBlockCenter(BlockPos.ofFloored(entity.getX(), entity.getY(), entity.getZ()), Registries.SOUND_EVENT.get(Identifier.of("midnightlurker:lurkeranger")), SoundCategory.NEUTRAL, 0, 0, false);
				}
			}
		}

		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1) {
			if (dataSaver.getPersistentData().getDouble("JumpscareTimer") == 0) {
				System.out.println("Set Jumpscare Timer.");
				dataSaver.getPersistentData().putDouble("JumpscareTimer", 46);
			}
		}

		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1 && dataSaver.getPersistentData().getDouble("JumpscareTimer") == 1) {
			System.out.println("Gen New Jumpscare Key");
			dataSaver.getPersistentData().putDouble("JumpscareActive", 0);
			dataSaver.getPersistentData().putDouble("JumpscareRandom", MathHelper.nextInt(Random.create(), 0, 2));
		}

		if (dataSaver.getPersistentData().getDouble("JumpscareTimer") > 0) {
			System.out.println("Decremented Jumpscare Timer.");
			double _setval = dataSaver.getPersistentData().getDouble("JumpscareTimer") - 1;
			dataSaver.getPersistentData().putDouble("JumpscareTimer", _setval);
		}

		if (dataSaver.getPersistentData().getDouble("JumpscareActive") == 1
				&& dataSaver.getPersistentData().getDouble("JumpscareTimer") <= 29
				&& dataSaver.getPersistentData().getDouble("JumpscareTimer") >= 1) {

			EntityTickActions.handleEffect(entity, MidnightlurkerModMobEffects.INSANITY, 155, 0, false, false);
			world.addParticle(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE, (x + MathHelper.nextDouble(Random.create(), -6, 6)), (y + MathHelper.nextDouble(Random.create(), 0, 6)), (z + MathHelper.nextDouble(Random.create(), -6, 6)), 0, 0, 0);
		}

        return dataSaver.getPersistentData().getDouble("JumpscareTimer") > 0 && doPopupJumpscare;
    }
}
