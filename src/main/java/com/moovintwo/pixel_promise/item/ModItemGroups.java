package com.moovintwo.pixel_promise.item;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final net.minecraft.item.ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Pixel_promise.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("pixel_promise.itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.LOGO)).entries((displayContext, entries) -> {
                        entries.add(ModItems.VOIDCHARM);
                        entries.add(ModItems.VOIDSHARD);
                        entries.add(ModBlocks.VOIDSHARD_DEPOSIT);


                    }).build());


    public static void registerItemGroups() {
        Pixel_promise.LOGGER.info("Registering Item Groups for " + Pixel_promise.MOD_ID);
    }
}