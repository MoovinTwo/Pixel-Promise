package com.moovintwo.pixel_promise.item;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.item.end.BindingCharm;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Items {
    public static final Item BINDING_CHARM = registerItem("binding_charm",
            new BindingCharm(new FabricItemSettings()
                    .maxCount(8)
                    .rarity(Rarity.EPIC)
            ));

    public static final Item VOID_SHARD = registerItem("void_shard", new Item(new FabricItemSettings()));
    public static final Item LOGO = registerItem("icon", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Pixel_promise.MOD_ID, name), item);
    }

    public static void registerItems() {
        Pixel_promise.LOGGER.info("Registering Mod Items for " + Pixel_promise.MOD_ID);
    }
}
