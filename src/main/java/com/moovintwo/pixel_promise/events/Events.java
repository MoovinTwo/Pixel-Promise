package com.moovintwo.pixel_promise.events;

import com.moovintwo.pixel_promise.Pixel_promise;
import com.moovintwo.pixel_promise.events.enchantment.sins.PrideEvent;

public class Events {

    public static void registerEvents() {

        PrideEvent.register();

        Pixel_promise.LOGGER.info("Registered mod Events for " + Pixel_promise.MOD_ID);
    }

}