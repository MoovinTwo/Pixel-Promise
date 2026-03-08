package com.moovintwo.pixel_promise.world.gen;

import com.moovintwo.pixel_promise.world.Pixel_PlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class Pixel_OreGeneration {

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, Pixel_PlacedFeatures.BLOODSTONE_DEPOSIT_PLACED_KEY);
    }

}
