package com.moovintwo.pixel_promise;

import com.moovintwo.pixel_promise.block.PillarType;
import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import com.moovintwo.pixel_promise.effect.Pixel_Effects;
import com.moovintwo.pixel_promise.enchantment.Pixel_Enchantments;
import com.moovintwo.pixel_promise.events.Pixel_Events;
import com.moovintwo.pixel_promise.item.Pixel_ItemGroups;
import com.moovintwo.pixel_promise.item.Pixel_Items;
import com.moovintwo.pixel_promise.world.gen.Pixel_WorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pixel_promise implements ModInitializer {
    public static final String MOD_ID = "pixel_promise";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        PillarType.registerBlocks();
        Pixel_Items.registerItems();
        Pixel_Blocks.registerBlocks();
        Pixel_ItemGroups.registerItemGroups();
        Pixel_Enchantments.registerEnchantments();
        Pixel_Events.registerEvents();
        Pixel_Effects.registerEffects();

        Pixel_WorldGeneration.generateWorldGen();

    }
}
