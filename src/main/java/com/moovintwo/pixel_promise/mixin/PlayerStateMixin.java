package com.moovintwo.pixel_promise.mixin;

import com.moovintwo.pixel_promise.state.PlayerState;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerStateMixin implements PlayerState {

    @Unique
    private static final TrackedData<Integer> PRIDEFULNESS =
            DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        ((PlayerEntity)(Object)this).getDataTracker().startTracking(PRIDEFULNESS, 0);
    }

    @Override
    public int getPridefulness() {
        return ((PlayerEntity)(Object)this).getDataTracker().get(PRIDEFULNESS);
    }

    @Override
    public void setPridefulness(int value) {
        ((PlayerEntity)(Object)this).getDataTracker().set(PRIDEFULNESS, value);
    }
}