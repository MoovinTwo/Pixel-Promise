package com.moovintwo.pixel_promise;

import com.moovintwo.pixel_promise.renderer.Chisel_ItemRenderer;
import com.moovintwo.pixel_promise.item.Pixel_Items;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class Pixel_promiseClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HudRenderCallback.EVENT.register(PlayerStateHud::renderHud);
        BuiltinItemRendererRegistry.INSTANCE.register(Pixel_Items.DIAMOND_CHISEL, new Chisel_ItemRenderer());


    }
}