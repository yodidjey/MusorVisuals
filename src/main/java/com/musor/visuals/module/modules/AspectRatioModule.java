package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для изменения соотношения сторон экрана.
 */
public class AspectRatioModule extends Module {
    public AspectRatioModule() {
        super("Aspect Ratio", "Изменение соотношения сторон");
    }

    @Override
    protected void initSettings() {
        settings.put("aspectRatio", 16.0f / 9.0f);
    }

    @Override
    public void onTick() {
        // Изменение соотношения сторон
    }
}
