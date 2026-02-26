package com.moovintwo.pixel_promise.item;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.block.Blocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final net.minecraft.item.ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Pixel_promise.MOD_ID, "group"),
            FabricItemGroup.builder().displayName(Text.translatable("pixel_promise.itemgroup.group"))
                    .icon(() -> new ItemStack(Items.LOGO)).entries((displayContext, entries) -> {
                        entries.add(Items.BINDING_CHARM);
                        entries.add(Items.VOID_SHARD);
                        entries.add(Blocks.VOID_SHARD_DEPOSIT);


                    }).build());


    public static void registerItemGroups() {
        Pixel_promise.LOGGER.info("Registering Item Groups for " + Pixel_promise.MOD_ID);
    }
}