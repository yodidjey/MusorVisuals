package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отключения дождя и изменения погоды.
 */
public class WeatherModifierModule extends Module {
    public WeatherModifierModule() {
        super("Weather Modifier", "Отключение осадков");
    }

    @Override
    protected void initSettings() {
        settings.put("disableRain", true);
        settings.put("disableSnow", true);
        settings.put("disableThunder", true);
    }

    @Override
    public void onTick() {
        // Реализация с миксинами
    }
}
