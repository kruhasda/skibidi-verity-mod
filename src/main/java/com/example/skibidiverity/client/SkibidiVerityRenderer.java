package com.example.skibidiverity.client;

import com.example.skibidiverity.SkibidiVerityMod;
import com.example.skibidiverity.entity.SkibidiVerityEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SkibidiVerityRenderer extends MobEntityRenderer<SkibidiVerityEntity, SkibidiVerityModel> {
    private static final Identifier TEXTURE = new Identifier(SkibidiVerityMod.MOD_ID, "textures/entity/skibidi_verity.png");

    public SkibidiVerityRenderer(EntityRendererFactory.Context context) {
        super(context, new SkibidiVerityModel(context.getPart(SkibidiVerityModClient.MODEL_LAYER)), 0.6F);
    }

    @Override
    public Identifier getTexture(SkibidiVerityEntity entity) {
        return TEXTURE;
    }
}
