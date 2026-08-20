package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения крыльев за спиной.
 */
public class WingsModule extends Module {
    public WingsModule() {
        super("Wings", "Косметические крылья за спиной");
    }

    @Override
    protected void initSettings() {
        settings.put("wingsColor", 0xFFFF00FF);
        settings.put("wingsScale", 1.0f);
        settings.put("wingsType", "angel");
        settings.put("animateWings", true);
    }

    @Override
    public void onTick() {
        // Рендеринг крыльев
    }
}
