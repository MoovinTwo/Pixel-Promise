package com.moovintwo.pixel_promise.datagen;

import com.moovintwo.pixel_promise.datagen.customBlockModel.PillarModelProvider;
import com.moovintwo.pixel_promise.world.Pixel_ConfiguredFeatures;
import com.moovintwo.pixel_promise.world.Pixel_PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class Pixel_promiseDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(Pixel_ModelProvider::new);
        pack.addProvider(Pixel_EngLangProvider::new);
        pack.addProvider(Pixel_BlockLootTableProvider::new);
        pack.addProvider(Pixel_BlockTagProvider::new);
        pack.addProvider(Pixel_ItemTagProvider::new);
        pack.addProvider(Pixel_WorldGenerator::new);
        pack.addProvider(PillarModelProvider::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, Pixel_ConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, Pixel_PlacedFeatures::bootstrap);
    }
}
