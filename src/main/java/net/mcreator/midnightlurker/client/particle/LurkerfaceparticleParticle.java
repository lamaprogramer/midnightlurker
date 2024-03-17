
package net.mcreator.midnightlurker.client.particle;



import net.minecraft.particle.DefaultParticleType;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;

public class LurkerfaceparticleParticle extends SpriteBillboardParticle {
	public static LurkerfaceparticleParticleFactory provider(SpriteProvider spriteSet) {
		return new LurkerfaceparticleParticleFactory(spriteSet);
	}

	public static class LurkerfaceparticleParticleFactory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider spriteSet;

		public LurkerfaceparticleParticleFactory(SpriteProvider spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(DefaultParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new LurkerfaceparticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteProvider spriteSet;

	protected LurkerfaceparticleParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setBoundingBoxSpacing(0.2f, 0.2f);
		this.scale *= 1.95f;
		this.maxAge = 40;
		this.gravityStrength = 0.02f;
		this.collidesWithWorld = false;
		this.velocityX = vx * 0;
		this.velocityY = vy * 0;
		this.velocityZ = vz * 0;
		this.setSpriteForAge(spriteSet);
	}

	@Override
	public int getBrightness(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.dead) {
			this.setSprite(this.spriteSet.getSprite((this.age / 3) % 13 + 1, 13));
		}
	}
}
