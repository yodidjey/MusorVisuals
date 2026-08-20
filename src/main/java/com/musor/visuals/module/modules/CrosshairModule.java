package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для кастомного прицела.
 */
public class CrosshairModule extends Module {
    public CrosshairModule() {
        super("Crosshair", "Кастомный прицел");
    }

    @Override
    protected void initSettings() {
        settings.put("crosshairType", "plus");
        settings.put("crosshairSize", 10.0f);
        settings.put("crosshairColor", 0xFFFFFFFF);
        settings.put("crosshairWidth", 1.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг прицела
    }
}
