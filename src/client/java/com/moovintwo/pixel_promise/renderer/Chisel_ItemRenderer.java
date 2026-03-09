package com.moovintwo.pixel_promise.renderer;

import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class Chisel_ItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices,
                       VertexConsumerProvider consumers, int light, int overlay) {

        MinecraftClient client = MinecraftClient.getInstance();
        LivingEntity entity = client.player;

        matrices.push();

        if (entity != null && entity.isUsingItem() && entity.getActiveItem() == stack) {

            // Smooth animation progress
            float progress = (stack.getMaxUseTime() - entity.getItemUseTimeLeft()
                    + client.getTickDelta())
                    / stack.getMaxUseTime();

            float strike;
            if (progress < 0.3f) {
                // lift with ease-out
                float liftProgress = progress / 0.3f;
                strike = - (float) Math.pow(liftProgress, 0.8) * 30f;
            } else if (progress < 0.6f) {
                // snap down quickly
                float snapProgress = (progress - 0.3f) / 0.3f;
                strike = -30f + snapProgress * 50f; // -30 → +20
            } else if (progress > 0.9f) {
                // recoil from impact
                float recoilProgress = (progress - 0.9f) / 0.1f;
                strike = 20f - recoilProgress * 10f; // 20 → 10
            } else {
                // pause at impact
                strike = 20f;
            }

            matrices.translate(0.2, 0.1, 0);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(strike));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(strike * 0.2f));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(strike * 0.1f));

            // Render the offhand item being chiseled
            ItemStack offhand = entity.getOffHandStack();

            if (offhand.isOf(Pixel_Items.UNPOLISHED_BLOODSTONE)) {

                matrices.push();

                // Position roughly at the tip of the chisel
                matrices.translate(0.3, 0.0, -0.5);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(strike * 0.5f));
                matrices.scale(0.7f, 0.7f, 0.7f);

                client.getItemRenderer().renderItem(
                        offhand,
                        ModelTransformationMode.FIXED,
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

        // Render the chisel itself
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