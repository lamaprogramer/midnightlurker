
package net.mcreator.midnightlurker.client.particle;


import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class VoidDotParticle extends SpriteBillboardParticle {
	public static VoidDotParticleFactory provider(SpriteProvider spriteSet) {
		return new VoidDotParticleFactory(spriteSet);
	}

	public static class VoidDotParticleFactory implements ParticleFactory<SimpleParticleType> {
		private final SpriteProvider spriteSet;

		public VoidDotParticleFactory(SpriteProvider spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new VoidDotParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteProvider spriteSet;

	protected VoidDotParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setBoundingBoxSpacing(0.2f, 0.2f);
		this.scale *= 0.7f;
		this.maxAge = 30;
		this.gravityStrength = 0.3f;
		this.collidesWithWorld = true;
		this.velocityX = vx * 0;
		this.velocityY = vy * 0;
		this.velocityZ = vz * 0;
		this.setSprite(spriteSet);
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
	}
}
