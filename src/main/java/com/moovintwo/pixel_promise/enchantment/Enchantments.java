package com.moovintwo.pixel_promise.enchantment;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.enchantment.sins.Pride;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Enchantments {

    private static final EquipmentSlot[] CHEST = new EquipmentSlot[] { EquipmentSlot.CHEST };

    public static Enchantment PRIDE = registerEnchantment("pride", new Pride(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, CHEST));

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Pixel_promise.MOD_ID, name), enchantment);
    }

    public static void registerEnchantments() {
        Pixel_promise.LOGGER.info("Registering Mod Enchantments for " + Pixel_promise.MOD_ID);
    }

}
