package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения конуса/шляпы над головой игрока.
 */
public class ChinaHatModule extends Module {
    public ChinaHatModule() {
        super("China Hat", "Конус над головой игрока");
    }

    @Override
    protected void initSettings() {
        settings.put("hatColor", 0xFFFF00FF);
        settings.put("hatSize", 0.5f);
        settings.put("hatHeight", 2.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг шляпы
    }
}
