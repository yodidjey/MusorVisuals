package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для панели информации о цели.
 */
public class TargetHUDModule extends Module {
    public TargetHUDModule() {
        super("Target HUD", "Панель с информацией о цели");
    }

    @Override
    protected void initSettings() {
        settings.put("hudX", 10.0f);
        settings.put("hudY", 10.0f);
        settings.put("hudWidth", 200.0f);
        settings.put("hudHeight", 100.0f);
        settings.put("backgroundColor", 0x80000000);
        settings.put("showSkin", true);
        settings.put("showHealth", true);
        settings.put("showArmor", true);
        settings.put("showPing", true);
    }

    @Override
    public void onTick() {
        // Рендеринг HUD цели
    }
}
