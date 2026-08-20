package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения логотипа и названия клиента.
 */
public class WatermarkModule extends Module {
    public WatermarkModule() {
        super("Watermark", "Логотип и стилизованная надпись клиента");
    }

    @Override
    protected void initSettings() {
        settings.put("watermarkX", 10.0f);
        settings.put("watermarkY", 10.0f);
        settings.put("textColor", 0xFFFFFFFF);
        settings.put("showFPS", true);
        settings.put("showPing", true);
        settings.put("textScale", 1.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг ватермарка
    }
}
