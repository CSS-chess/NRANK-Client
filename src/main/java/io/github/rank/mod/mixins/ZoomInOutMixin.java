package io.github.rank.mod.mixins;

import io.github.rank.mod.ZoomMod;

import net.minecraft.entity.player.PlayerInventory;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerInventory.class)
public class ZoomInOutMixin {
    @Inject(at = {@At("HEAD")}, method = {"scrollInHotbar(D)V"}, cancellable = true)
    private void onScrollInHotbar(double scrollAmount, CallbackInfo ci)
    { if (ZoomMod.INSTANCE.getZoomKey().isPressed()) ci.cancel(); }
}
