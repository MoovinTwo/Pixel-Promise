package com.moovintwo.pixel_promise;

import com.moovintwo.pixel_promise.enchantment.Pixel_Enchantments;
import com.moovintwo.pixel_promise.state.PlayerState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerStateHud {

    static void renderHud(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player == null) return;

        PlayerState state = (PlayerState) player;
        int pride = state.getPridefulness();
        String hudText = String.format("Pride: %d", pride);
        var chestStack = player.getInventory().getArmorStack(2);
        int prideLevel = EnchantmentHelper.getLevel(Pixel_Enchantments.PRIDE, chestStack);

        int prideValuePlace;

        if (pride == 0) {
            prideValuePlace = 1;
        } else {
            prideValuePlace = (int) (Math.floor(Math.log10(pride)) + 1);
        }

        if (prideLevel > 0) {
            drawContext.fill(8, 8, 50 + prideValuePlace * 5, 19, 0xFF575757);
            drawContext.drawTextWithShadow(client.textRenderer, hudText, 10, 10, (pride <= 100) ? 0xFFFF00 : 0xFF442E);
        }

    }
}