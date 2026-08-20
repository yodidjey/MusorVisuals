package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для настройки тумана.
 */
public class CustomFogModule extends Module {
    public CustomFogModule() {
        super("Custom Fog", "Настройка цвета и плотности тумана");
    }

    @Override
    protected void initSettings() {
        settings.put("fogDensity", 0.5f);
        settings.put("fogDistance", 100.0f);
        settings.put("fogRed", 0.8f);
        settings.put("fogGreen", 0.8f);
        settings.put("fogBlue", 0.8f);
    }

    @Override
    public void onTick() {
        // Реализация с RenderSystem
    }
}
