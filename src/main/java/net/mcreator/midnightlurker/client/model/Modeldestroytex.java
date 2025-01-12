package net.mcreator.midnightlurker.client.model;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

// Made with Blockbench 4.8.3
// Exported for MinecraftClient version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldestroytex<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererFactory.Context in
	// the entity renderer and passed into this model's constructor

	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of("midnightlurker", "modeldestroytex"), "main");
	public final ModelPart bb_main;

	public Modeldestroytex(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		
		ModelPartData partdefinition = meshdefinition.getRoot();
		ModelPartData bb_main = partdefinition.addChild("bb_main", ModelPartBuilder.create().uv(-1, -1).cuboid(-8.5F, -48.5F, -8.5F, 17.0F, 49.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(meshdefinition, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		bb_main.render(matrices, vertices, light, overlay, color);
	}
	
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}
}
