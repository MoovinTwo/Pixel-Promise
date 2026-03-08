package com.moovintwo.pixel_promise.datagen;

import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class Pixel_ModelProvider extends FabricModelProvider {
    public Pixel_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(Pixel_Blocks.BLOODSTONE_DEPOSIT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Pixel_Items.LOGO, Models.GENERATED);
        itemModelGenerator.register(Pixel_Items.BINDING_CHARM, Models.GENERATED);
        itemModelGenerator.register(Pixel_Items.UNPOLISHED_BLOODSTONE, Models.GENERATED);
        itemModelGenerator.register(Pixel_Items.POLISHED_BLOODSTONE, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Pixel_ModelProvider";
    }
}