package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения прочности брони и предметов.
 */
public class ArmorHUDModule extends Module {
    public ArmorHUDModule() {
        super("Armor HUD", "Отображение брони и прочности предметов");
    }

    @Override
    protected void initSettings() {
        settings.put("armorX", 10.0f);
        settings.put("armorY", 50.0f);
        settings.put("showDamage", true);
        settings.put("showDurabilityBar", true);
        settings.put("backgroundColor", 0x80000000);
    }

    @Override
    public void onTick() {
        // Рендеринг брони
    }
}
