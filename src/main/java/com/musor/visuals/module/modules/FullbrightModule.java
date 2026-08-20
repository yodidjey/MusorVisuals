package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для максимальной яркости без темноты.
 */
public class FullbrightModule extends Module {
    public FullbrightModule() {
        super("Fullbright", "Максимальная яркость без темноты");
    }

    @Override
    protected void initSettings() {
        settings.put("gamma", 16.0f);
        settings.put("blockBrightness", 1.0f);
    }

    @Override
    public void onTick() {
        // Изменение яркости
    }
}
