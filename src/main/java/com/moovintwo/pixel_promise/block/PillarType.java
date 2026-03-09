package com.moovintwo.pixel_promise.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class PillarType {

    public static final List<PillarType> PILLARS = new ArrayList<>();

    private final String name;
    private final Block baseBlock;
    private Block pillarBlock;

    public PillarType(String name, Block baseBlock) {
        this.name = name;
        this.baseBlock = baseBlock;
    }

    public String name() {
        return name;
    }

    public Block baseBlock() {
        return baseBlock;
    }

    public Block pillarBlock() {
        return pillarBlock;
    }

    public static final PillarType POLISHED_DEEPSLATE =
            registerType("polished_deepslate", Blocks.POLISHED_DEEPSLATE);

    public static final PillarType DEEPSLATE_BRICK =
            registerType("deepslate_brick", Blocks.DEEPSLATE_BRICKS);

    public static PillarType registerType(String name, Block baseBlock) {
        PillarType type = new PillarType(name, baseBlock);
        PILLARS.add(type);
        return type;
    }

    public static void registerBlocks() {

        for (PillarType type : PILLARS) {

            Identifier id = new Identifier("pixel_promise", type.name + "_pillar");

            Block block = Registry.register(
                    Registries.BLOCK,
                    id,
                    new PillarBlock(AbstractBlock.Settings.copy(type.baseBlock))
            );

            Registry.register(
                    Registries.ITEM,
                    id,
                    new BlockItem(block, new Item.Settings())
            );

            type.pillarBlock = block;
        }
    }
}