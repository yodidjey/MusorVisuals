package com.musor.visuals.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.Camera;

/**
 * Аксессор для доступа к приватным полям камеры.
 */
@Mixin(Camera.class)
public interface MixinCameraAccessor {
    @Accessor("x")
    double getX();

    @Accessor("y")
    double getY();

    @Accessor("z")
    double getZ();
}
