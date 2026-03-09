package com.moovintwo.pixel_promise.datagen.customBlockModel;

import com.moovintwo.pixel_promise.block.PillarBlock;
import com.moovintwo.pixel_promise.block.PillarType;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PillarModelProvider extends FabricModelProvider {

    private static final String MOD_ID = "pixel_promise";

    public PillarModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final Model PILLAR =
            new Model(
                    Optional.of(new Identifier(MOD_ID, "block/templates/pillar")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            );

    private static final Model PILLAR_BASE =
            new Model(
                    Optional.of(new Identifier(MOD_ID, "block/templates/pillar_base")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            );

    private static final Model PILLAR_CENTER =
            new Model(
                    Optional.of(new Identifier(MOD_ID, "block/templates/pillar_center")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            );

    private static final Model PILLAR_TOP =
            new Model(
                    Optional.of(new Identifier(MOD_ID, "block/templates/pillar_top")),
                    Optional.empty(),
                    TextureKey.TEXTURE
            );

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        for (PillarType type : PillarType.PILLARS) {

            Block block = type.pillarBlock();
            String name = type.name();

            // Model texture (your pillar texture)
            Identifier modelTexture = new Identifier(MOD_ID, "block/pillars/" + name);

            // Particle texture (vanilla base block texture)
            Identifier particleTexture = new Identifier("minecraft", "block/" + (type.baseBlock() != null ? Registries.BLOCK.getId(type.baseBlock()).getPath() : "stone"));

            LOGGER.info("Particle Registry: " + particleTexture);

            TextureMap textures = new TextureMap()
                    .put(TextureKey.TEXTURE, modelTexture)
                    .put(TextureKey.PARTICLE, particleTexture);

            // Upload each model
            Identifier pillarModel =
                    PILLAR.upload(new Identifier(MOD_ID,
                                    "block/pillars/" + name + "/pillar"),
                            textures,
                            gen.modelCollector);

            Identifier baseModel =
                    PILLAR_BASE.upload(new Identifier(MOD_ID,
                                    "block/pillars/" + name + "/pillar_base"),
                            textures,
                            gen.modelCollector);

            Identifier centerModel =
                    PILLAR_CENTER.upload(new Identifier(MOD_ID,
                                    "block/pillars/" + name + "/pillar_center"),
                            textures,
                            gen.modelCollector);

            Identifier topModel =
                    PILLAR_TOP.upload(new Identifier(MOD_ID,
                                    "block/pillars/" + name + "/pillar_top"),
                            textures,
                            gen.modelCollector);

            // Blockstates with ABOVE/BELOW variants
            gen.blockStateCollector.accept(
                    VariantsBlockStateSupplier.create(block)
                            .coordinate(
                                    BlockStateVariantMap.create(
                                                    PillarBlock.ABOVE,
                                                    PillarBlock.BELOW
                                            )
                                            .register(false, false,
                                                    BlockStateVariant.create().put(VariantSettings.MODEL, pillarModel))
                                            .register(true, false,
                                                    BlockStateVariant.create().put(VariantSettings.MODEL, topModel))
                                            .register(false, true,
                                                    BlockStateVariant.create().put(VariantSettings.MODEL, baseModel))
                                            .register(true, true,
                                                    BlockStateVariant.create().put(VariantSettings.MODEL, centerModel))
                            )
            );
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        for (PillarType type : PillarType.PILLARS) {
            Item item = type.pillarBlock().asItem();

            // Use the pillar model for items
            gen.register(item, new Model(
                    Optional.of(new Identifier(MOD_ID, "block/pillars/" + type.name() + "/pillar")),
                    Optional.empty()
            ));
        }
    }
}