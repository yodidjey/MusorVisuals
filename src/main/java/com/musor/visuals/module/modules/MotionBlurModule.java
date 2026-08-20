package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class MotionBlurModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public MotionBlurModule() {
        super("Motion Blur", "Эффект размытия при движении камеры");
    }

    @Override
    protected void initSettings() {
        settings.put("blurAmount", 0.3f);
        settings.put("blurFPS", 60.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Применение Motion Blur
    }
}
