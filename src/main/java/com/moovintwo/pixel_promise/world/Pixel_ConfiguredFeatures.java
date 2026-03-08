package com.moovintwo.pixel_promise.world;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.block.Pixel_Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;


public class Pixel_ConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLOODSTONE_DEPOSIT_KEY = registerKey("bloodstone_deposit");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldBloodstoneOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceable, Pixel_Blocks.BLOODSTONE_DEPOSIT.getDefaultState()));

        register(context, BLOODSTONE_DEPOSIT_KEY, Feature.ORE, new OreFeatureConfig(overworldBloodstoneOres, 1));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Pixel_promise.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
