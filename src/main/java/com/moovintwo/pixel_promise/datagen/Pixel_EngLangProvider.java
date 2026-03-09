package com.moovintwo.pixel_promise.datagen;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.block.PillarType;
import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import com.moovintwo.pixel_promise.effect.Pixel_Effects;
import com.moovintwo.pixel_promise.enchantment.Pixel_Enchantments;
import com.moovintwo.pixel_promise.item.Pixel_ItemGroups;
import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class Pixel_EngLangProvider extends FabricLanguageProvider {

    protected Pixel_EngLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    private String tooltipKey(String key) {
      return "tooltip." + Pixel_promise.MOD_ID + "." + key;
    }


    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(Pixel_Items.BINDING_CHARM, "Binding Charm");
        translationBuilder.add(Pixel_Items.LOGO, "Logo");
        translationBuilder.add(Pixel_Items.UNPOLISHED_BLOODSTONE, "Unpolished Bloodstone");
        translationBuilder.add(Pixel_Items.POLISHED_BLOODSTONE, "Polished Bloodstone");

        translationBuilder.add(Pixel_Items.DIAMOND_CHISEL, "Diamond Chisel");

        translationBuilder.add(Pixel_Blocks.BLOODSTONE_DEPOSIT, "Bloodstone Deposit");

        translationBuilder.add(Pixel_Effects.FRACTURED_KEY, "Fractured");

        translationBuilder.add(Pixel_Enchantments.PRIDE, "Pride");

        translationBuilder.add(Pixel_ItemGroups.SIN_GROUP_KEY, "Pixel Sin Group");

        translationBuilder.add(tooltipKey("binding_charm"), "A ring that binds you to an evil force");

        for (PillarType type : PillarType.PILLARS) {

            String name = type.name().replace("_", " ");
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

            translationBuilder.add(
                    type.pillarBlock(),
                    name + " Pillar"
            );
        }

    }

}