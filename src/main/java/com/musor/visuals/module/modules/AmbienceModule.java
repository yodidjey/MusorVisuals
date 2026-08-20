package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для изменения атмосферы мира (время суток, цвет неба).
 */
public class AmbienceModule extends Module {
    public AmbienceModule() {
        super("Ambience", "Изменение времени суток и цвета неба");
    }

    @Override
    protected void initSettings() {
        settings.put("time", 6000.0f);
        settings.put("skyRed", 1.0f);
        settings.put("skyGreen", 1.0f);
        settings.put("skyBlue", 1.0f);
    }

    @Override
    public void onTick() {
        if (enabled) {
            // Будет реализовано с миксинами
        }
    }
}
