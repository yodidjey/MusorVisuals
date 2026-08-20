package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для свечения контуров сущностей.
 */
public class GlowESPModule extends Module {
    public GlowESPModule() {
        super("Glow ESP", "Свечение контуров сущностей");
    }

    @Override
    protected void initSettings() {
        settings.put("glowColor", 0xFF00FF00);
        settings.put("glowIntensity", 1.0f);
        settings.put("outlineWidth", 2.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг свечения
    }
}
