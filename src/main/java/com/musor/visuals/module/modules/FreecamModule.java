package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для свободной камеры.
 */
public class FreecamModule extends Module {
    public FreecamModule() {
        super("Freecam", "Свободная камера для наблюдения");
    }

    @Override
    protected void initSettings() {
        settings.put("freecamSpeed", 0.5f);
        settings.put("freecamBoostMultiplier", 2.0f);
    }

    @Override
    public void onTick() {
        // Реализация свободной камеры
    }
}
