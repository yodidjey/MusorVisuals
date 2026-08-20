package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отключения визуальных элементов.
 */
public class NoRenderModule extends Module {
    public NoRenderModule() {
        super("NoRender", "Отключение элементов: огонь, слепота, тотемы, взрывы");
    }

    @Override
    protected void initSettings() {
        settings.put("noFire", true);
        settings.put("noBlindness", true);
        settings.put("noTotem", true);
        settings.put("noExplosion", false);
        settings.put("noWitherSkulls", false);
    }

    @Override
    public void onTick() {
        // Отключение элементов рендеринга
    }
}
