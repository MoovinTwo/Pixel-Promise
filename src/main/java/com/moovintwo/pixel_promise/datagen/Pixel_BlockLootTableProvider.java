package com.moovintwo.pixel_promise.datagen;

import com.moovintwo.pixel_promise.block.PillarType;
import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class Pixel_BlockLootTableProvider extends FabricBlockLootTableProvider {
    protected Pixel_BlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(Pixel_Blocks.BLOODSTONE_DEPOSIT, oreDrops(Pixel_Blocks.BLOODSTONE_DEPOSIT, Pixel_Items.UNPOLISHED_BLOODSTONE));

        for (PillarType type : PillarType.PILLARS) {
            addDrop(type.pillarBlock(), type.pillarBlock());
        }

    }
}
