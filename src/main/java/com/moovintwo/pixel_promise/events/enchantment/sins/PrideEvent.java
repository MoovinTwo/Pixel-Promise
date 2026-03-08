package com.moovintwo.pixel_promise.events.enchantment.sins;

import com.moovintwo.pixel_promise.effect.Pixel_Effects;
import com.moovintwo.pixel_promise.enchantment.Pixel_Enchantments;
import com.moovintwo.pixel_promise.state.PlayerState;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

public class PrideEvent {

    public static void register() {

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {

            if (entity instanceof PlayerEntity player) {

                PlayerState state = (PlayerState) player;

                var chestStack = player.getInventory().getArmorStack(2);

                int level = EnchantmentHelper.getLevel(Pixel_Enchantments.PRIDE, chestStack);

                if (level > 0) {


                    var attacker = source.getAttacker();

                    if (attacker instanceof LivingEntity livingAttacker) {

                        if (state.getPridefulness() < 100) {
                            state.setPridefulness(state.getPridefulness() + 5);
                            if (state.getPridefulness() >= 100) {
                                StatusEffectInstance fractured = new StatusEffectInstance(Pixel_Effects.FRACTURED, 600, 0);
                                player.addStatusEffect(fractured);
                            }
                        } else {

                            state.setPridefulness(state.getPridefulness() + 5);

                            int prideOverflow = (state.getPridefulness() - 100)/10;
                            StatusEffectInstance currentFractured = player.getStatusEffect(Pixel_Effects.FRACTURED);

                            int overflowDuration = 600;
                            if (currentFractured != null) {
                                overflowDuration = currentFractured.getDuration() + 60;
                            }

                            if (currentFractured == null || currentFractured.getAmplifier() != prideOverflow) {
                                player.addStatusEffect(new StatusEffectInstance(
                                        Pixel_Effects.FRACTURED,
                                        overflowDuration,
                                        prideOverflow
                                ));
                            }

                        }

                    }
                }
            }

            return true;
        });
    }

}