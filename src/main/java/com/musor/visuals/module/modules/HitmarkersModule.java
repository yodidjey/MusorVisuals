package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для показателей урона и попаданий.
 */
public class HitmarkersModule extends Module {
    public HitmarkersModule() {
        super("Hitmarkers", "Показатели урона и попаданий");
    }

    @Override
    protected void initSettings() {
        settings.put("hitmarkerType", "sound");
        settings.put("hitmarkerSize", 10.0f);
        settings.put("damageIndicator", true);
    }

    @Override
    public void onTick() {
        // Отображение хитмаркеров
    }
}
