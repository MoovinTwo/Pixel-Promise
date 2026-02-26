package com.moovintwo.pixel_promise.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Fractured extends StatusEffect {

    protected Fractured() {

        super(StatusEffectCategory.HARMFUL, 0xfdff9a);

    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }

    // Called when the effect is applied
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }

}
