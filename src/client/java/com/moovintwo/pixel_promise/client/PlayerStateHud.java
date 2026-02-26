package com.moovintwo.pixel_promise.client;

import com.moovintwo.pixel_promise.state.PlayerState;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerStateHud implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(this::renderHud);
    }

    private void renderHud(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player == null) return;

        // Cast to PlayerState
        PlayerState state = (PlayerState) player;

        // Read values
        int pride = state.getPridefulness();

        // Build HUD string
        String hudText = String.format(
                "Pride: %d",
                pride
        );

        // Draw string using DrawContext

        if (pride <= 100) {
            drawContext.drawTextWithShadow(
                    client.textRenderer,    // TextRenderer
                    hudText,                // string
                    10,                     // x
                    10,                     // y
                    0xFFFF00                // color
            );
        } else {
            drawContext.drawTextWithShadow(
                    client.textRenderer,    // TextRenderer
                    hudText,                // string
                    10,                     // x
                    10,                     // y
                    0xff442e               // color
            );
        }
    }
}