package com.musor.visuals.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.renderer.LevelRenderer;

/**
 * Миксин для модификации рендеринга мира.
 */
@Mixin(LevelRenderer.class)
public class MixinWorldRenderer {
    // Методы для модификации рендеринга мира
}
