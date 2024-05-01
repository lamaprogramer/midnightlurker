
package net.mcreator.midnightlurker.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class VoidGatewayParticleParticle extends SpriteBillboardParticle {
	public static VoidGatewayParticleFactory provider(SpriteProvider spriteSet) {
		return new VoidGatewayParticleFactory(spriteSet);
	}

	public static class VoidGatewayParticleFactory implements ParticleFactory<SimpleParticleType> {
		private final SpriteProvider spriteSet;

		public VoidGatewayParticleFactory(SpriteProvider spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new VoidGatewayParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteProvider spriteSet;

	protected VoidGatewayParticleParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setBoundingBoxSpacing(0.2f, 0.2f);
		this.scale *= 0.7f;
		this.maxAge = 30;
		this.gravityStrength = -0.2f;
		this.collidesWithWorld = false;
		this.velocityX = vx * 0;
		this.velocityY = vy * 0;
		this.velocityZ = vz * 0;
		this.setSpriteForAge(spriteSet);
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.dead) {
			this.setSprite(this.spriteSet.getSprite((this.age / 3) % 12 + 1, 12));
		}
	}
}
