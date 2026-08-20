package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для уникального указателя на текущую цель.
 */
public class TargetESPModule extends Module {
    public TargetESPModule() {
        super("Target ESP", "Указатель на текущую цель");
    }

    @Override
    protected void initSettings() {
        settings.put("markColor", 0xFFFF0000);
        settings.put("markSize", 5.0f);
        settings.put("markType", "circle");
    }

    @Override
    public void onTick() {
        // Рендеринг указателя цели
    }
}
