package com.moovintwo.pixel_promise.item;

import com.moovintwo.pixel_promise.Pixel_promise;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VOIDCHARM = registerItem("voidcharm", new Item(new FabricItemSettings()));
    public static final Item VOIDSHARD = registerItem("voidshard", new Item(new FabricItemSettings()));
    public static final Item LOGO = registerItem("icon", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Pixel_promise.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Pixel_promise.LOGGER.info("Registering Mod Items for " + Pixel_promise.MOD_ID);
    }
}
