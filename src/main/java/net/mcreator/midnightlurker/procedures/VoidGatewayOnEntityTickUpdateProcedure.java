package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

import java.io.File;

public class VoidGatewayOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		if (entity.getPersistentData().getDouble("PlayerActivationGateway") >= 1) {
			if (entity instanceof VoidGatewayEntity) {
				((VoidGatewayEntity) entity).setAnimation("gatewayclose");
			}
		}
		if (entity.getPersistentData().getDouble("CloseTime") >= 9) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("PlayerActivationGateway") <= 0 && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			entity.getPersistentData().putDouble("PlayerActivationGateway", (entity.getPersistentData().getDouble("PlayerActivationGateway") + 1));
		}
		if (entity.getPersistentData().getDouble("PlayerActivationGateway") >= 1 && entity.getPersistentData().getDouble("CloseTime") < 9) {
			entity.getPersistentData().putDouble("CloseTime", (entity.getPersistentData().getDouble("CloseTime") + 1));
		}
		if (entity.getPersistentData().getDouble("CloseTime") == 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (entity.getPersistentData().getDouble("PlayerActivationGateway") >= 1 && entity.getPersistentData().getDouble("CloseTime") == 6) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom = Mth.nextDouble(RandomSource.create(), 1, 10);
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if (entity.getPersistentData().getDouble("PlayerActivationGateway") >= 1 && entity.getPersistentData().getDouble("CloseTime") == 8) {
			if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom < 8 && entity.getPersistentData().getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
					if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("JumpscareActive") < 1) {
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().putDouble("JumpscareActive", 1);
					}
				});
			} else if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom > 7 && entity.getPersistentData().getDouble("CloseTime") == 8) {
				MidnightlurkerMod.queueServerWork(10, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:insanitygoesbacksound")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:insanitygoesbacksound")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("InsanityStage") > 0) {
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().putDouble("InsanityStage",
								(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getPersistentData().getDouble("InsanityStage") - 1));
					}
				});
			}
		}
		if (Math.random() > 0.9) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get()), x, y, z, 1, 0.18, 0.2, 0.18, 0.1);
		}
	}
}
