package com.moovintwo.pixel_promise.enchantment.sins;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class Pride extends Enchantment {

    public Pride(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slots) {
        super(rarity, target, slots);
    }

    // Only one level
    @Override
    public int getMaxLevel() {
        return 1;
    }

    // Treasure enchantment
    @Override
    public boolean isTreasure() {
        return false;
    }

    // Prevent enchanting table
    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    // Allow villager trades & loot books
    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }
}
