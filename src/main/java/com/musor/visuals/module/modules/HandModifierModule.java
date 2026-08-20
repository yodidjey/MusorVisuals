package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для изменения положения и размера рук/предметов.
 */
public class HandModifierModule extends Module {
    public HandModifierModule() {
        super("Hand Modifier", "Изменение положения рук и предметов");
    }

    @Override
    protected void initSettings() {
        settings.put("handOffsetX", 0.0f);
        settings.put("handOffsetY", 0.0f);
        settings.put("handScale", 1.0f);
    }

    @Override
    public void onTick() {
        // Модификация положения рук
    }
}
