package com.example.skibidiverity;

import com.example.skibidiverity.client.SkibidiVerityModel;
import com.example.skibidiverity.client.SkibidiVerityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class SkibidiVerityModClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
            new Identifier(SkibidiVerityMod.MOD_ID, "skibidi_verity"), "main"
    );

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(MODEL_LAYER, SkibidiVerityModel::getTexturedModelData);
        EntityRendererRegistry.register(SkibidiVerityMod.SKIBIDI_VERITY, SkibidiVerityRenderer::new);
    }
}
