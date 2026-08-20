package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для расширенных плашек имен (2D/3D).
 */
public class NameTagsModule extends Module {
    public NameTagsModule() {
        super("NameTags", "Расширенные плашки имен с информацией");
    }

    @Override
    protected void initSettings() {
        settings.put("show2D", true);
        settings.put("showHealth", true);
        settings.put("showArmor", true);
        settings.put("showDistance", true);
        settings.put("backgroundColor", 0x80000000);
        settings.put("textScale", 1.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг NameTags
    }
}
