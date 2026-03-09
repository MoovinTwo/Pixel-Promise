package com.moovintwo.pixel_promise.mixin;

import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    @Inject(
            method = "renderFirstPersonItem",
            at = @At("HEAD")
    )
    private void pixelPromise$animateChisel(
            AbstractClientPlayerEntity player,
            float tickDelta,
            float pitch,
            Hand hand,
            float swingProgress,
            ItemStack stack,
            float equipProgress,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci
    ) {

        if (!stack.isOf(Pixel_Items.DIAMOND_CHISEL)) return;

        if (!player.isUsingItem()) return;

        if (player.getActiveItem() != stack) return;

        float progress =
                (stack.getMaxUseTime() - player.getItemUseTimeLeft() + tickDelta)
                        / stack.getMaxUseTime();

        // hammer strike animation
        float strike = (float) Math.sin(progress * Math.PI * 4);

        matrices.translate(0.2, 0.1, 0);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(strike * 40f));
    }
}