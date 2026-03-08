package com.moovintwo.pixel_promise.datagen;


import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class Pixel_BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public Pixel_BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Pixel_Blocks.BLOODSTONE_DEPOSIT);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Pixel_Blocks.BLOODSTONE_DEPOSIT);

    }
}