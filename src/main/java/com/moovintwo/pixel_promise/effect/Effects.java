package com.moovintwo.pixel_promise.effect;

import com.moovintwo.pixel_promise.Pixel_promise;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Effects {

    public static final StatusEffect FRACTURED = registerEffect("fractured", new Fractured());

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Pixel_promise.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        Pixel_promise.LOGGER.info("Registering Mod Effects for " + Pixel_promise.MOD_ID);
    }

}
