package com.example.skibidiverity.client;

import com.example.skibidiverity.entity.SkibidiVerityEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SkibidiVerityModel extends EntityModel<SkibidiVerityEntity> {
    private final ModelPart root;
    private final ModelPart verityHead;

    public SkibidiVerityModel(ModelPart root) {
        this.root = root;
        this.verityHead = root.getChild("verity_head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("bowl",
                ModelPartBuilder.create()
                        .uv(0, 20).cuboid(-6.0F, 14.0F, -6.0F, 12.0F, 10.0F, 12.0F),
                ModelTransform.NONE);

        modelPartData.addChild("tank",
                ModelPartBuilder.create()
                        .uv(0, 42).cuboid(-6.0F, 2.0F, 3.0F, 12.0F, 12.0F, 5.0F),
                ModelTransform.NONE);

        modelPartData.addChild("verity_head",
                ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F),
                ModelTransform.pivot(0.0F, 14.0F, -1.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(SkibidiVerityEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.verityHead.yaw = headYaw * ((float) Math.PI / 180F);
        this.verityHead.pitch = headPitch * ((float) Math.PI / 180F);
        this.verityHead.pivotY = 14.0F + MathHelper.sin(animationProgress * 0.4F) * 1.5F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
