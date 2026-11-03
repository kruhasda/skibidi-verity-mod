package com.example.skibidiverity;

import com.example.skibidiverity.entity.SkibidiVerityEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class SkibidiVerityMod implements ModInitializer {
    public static final String MOD_ID = "skibidiverity";

    public static final EntityType<SkibidiVerityEntity> SKIBIDI_VERITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "skibidi_verity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SkibidiVerityEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9F, 1.6F))
                    .build()
    );

    public static final Item SKIBIDI_VERITY_SPAWN_EGG = Registry.register(
            Registries.ITEM,
            new Identifier(MOD_ID, "skibidi_verity_spawn_egg"),
            new SpawnEggItem(SKIBIDI_VERITY, 0xFFFFFF, 0xFFD800, new Item.Settings())
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(SKIBIDI_VERITY, SkibidiVerityEntity.createAttributes());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(SKIBIDI_VERITY_SPAWN_EGG);
        });

        SpawnRestriction.register(
                SKIBIDI_VERITY,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                SKIBIDI_VERITY,
                60, 1, 3
        );
    }
}
