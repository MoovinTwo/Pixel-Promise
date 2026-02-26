package com.moovintwo.pixel_promise.mixin;

import com.moovintwo.pixel_promise.effect.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class EffectMixin {

    @ModifyVariable(
            method = "damage",
            at = @At("HEAD"),
            argsOnly = true
    )
    private float modifyFracturedDamage(float amount, DamageSource source) {

        LivingEntity entity = (LivingEntity)(Object)this;

        if (!entity.hasStatusEffect(Effects.FRACTURED)) {
            return amount;
        }

        StatusEffectInstance effect =
                entity.getStatusEffect(Effects.FRACTURED);

        if (effect == null) {
            return amount;
        }

        int level = effect.getAmplifier() + 1;

        float multiplier = 1.0f + (0.1f * level);

        return amount * multiplier;
    }
}