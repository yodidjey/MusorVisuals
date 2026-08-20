package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для кастомизации неба, звезд и луны.
 */
public class CustomSkyModule extends Module {
    public CustomSkyModule() {
        super("Custom Sky", "Кастомизация неба, звезд и луны");
    }

    @Override
    protected void initSettings() {
        settings.put("customStars", true);
        settings.put("customMoon", true);
        settings.put("moonScale", 1.0f);
        settings.put("starBrightness", 1.0f);
    }

    @Override
    public void onTick() {
        // Реализация с рендерингом
    }
}
