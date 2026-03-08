package com.moovintwo.pixel_promise.block;

import com.moovintwo.pixel_promise.Pixel_promise;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class Pixel_Blocks {
    public static final Block BLOODSTONE_DEPOSIT = registerBlock("bloodstone_deposit",
            new ExperienceDroppingBlock(FabricBlockSettings
                    .copyOf(net.minecraft.block.Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f)
                    .solid(),
                    UniformIntProvider.create(5,15)
            ));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pixel_promise.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Pixel_promise.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        Pixel_promise.LOGGER.info("Registering ModBlocks for " + Pixel_promise.MOD_ID);
    }
}
