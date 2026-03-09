package com.moovintwo.pixel_promise;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class ItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack stack,
                       ModelTransformationMode mode,
                       MatrixStack matrices,
                       VertexConsumerProvider consumers,
                       int light,
                       int overlay) {

        MinecraftClient client = MinecraftClient.getInstance();
        LivingEntity entity = client.player;

        matrices.push();

        // simple animation example
        float time = (System.currentTimeMillis() % 3600) / 10f;
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(time));

        client.getItemRenderer().renderItem(
                stack,
                mode,
                light,
                overlay,
                matrices,
                consumers,
                client.world,
                0
        );

        matrices.pop();
    }
}
