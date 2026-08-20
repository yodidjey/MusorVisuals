package com.musor.visuals.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.renderer.GameRenderer;

/**
 * Миксин для интеграции в рендеринг игры.
 */
@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(float tickDelta, long nanoTime, boolean tick, CallbackInfo ci) {
        // Хук для рендеринга визуалов
    }
}
