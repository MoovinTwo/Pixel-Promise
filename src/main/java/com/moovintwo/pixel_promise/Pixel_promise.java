package com.moovintwo.pixel_promise;

import com.moovintwo.pixel_promise.block.ModBlocks;
import com.moovintwo.pixel_promise.item.ModItemGroups;
import com.moovintwo.pixel_promise.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pixel_promise implements ModInitializer {
    public static final String MOD_ID = "pixel_promise";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

    }
}
