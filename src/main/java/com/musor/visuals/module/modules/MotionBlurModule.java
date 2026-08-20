package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для эффекта размытия движения.
 */
public class MotionBlurModule extends Module {
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
        // Реализация с шейдерами
    }
}
