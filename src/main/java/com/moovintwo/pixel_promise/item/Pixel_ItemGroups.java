package com.moovintwo.pixel_promise.item;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Pixel_ItemGroups {

    public static final String SIN_GROUP_KEY = "itemGroup." + Pixel_promise.MOD_ID + ".pixel_promise_group";

    public static final net.minecraft.item.ItemGroup PIXEL_PROMISE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Pixel_promise.MOD_ID, "pixel_sin_group"),
            FabricItemGroup.builder().displayName(Text.translatable(SIN_GROUP_KEY))
                    .icon(() -> new ItemStack(Pixel_Items.LOGO)).entries((displayContext, entries) -> {
                        entries.add(Pixel_Items.BINDING_CHARM);
                        entries.add(Pixel_Items.UNPOLISHED_BLOODSTONE);
                        entries.add(Pixel_Items.POLISHED_BLOODSTONE);
                        entries.add(Pixel_Blocks.BLOODSTONE_DEPOSIT);
                    }).build());


    public static void registerItemGroups() {
        Pixel_promise.LOGGER.info("Registering Item Groups for " + Pixel_promise.MOD_ID);
    }
}