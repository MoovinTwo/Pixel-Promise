package com.moovintwo.pixel_promise;

import com.moovintwo.pixel_promise.block.Blocks;
import com.moovintwo.pixel_promise.effect.Effects;
import com.moovintwo.pixel_promise.enchantment.Enchantments;
import com.moovintwo.pixel_promise.events.Events;
import com.moovintwo.pixel_promise.item.ItemGroups;
import com.moovintwo.pixel_promise.item.Items;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pixel_promise implements ModInitializer {
    public static final String MOD_ID = "pixel_promise";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ItemGroups.registerItemGroups();
        Items.registerItems();
        Blocks.registerBlocks();
        Enchantments.registerEnchantments();
        Events.registerEvents();
        Effects.registerEffects();

    }
}
