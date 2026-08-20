package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для рисования линий от центра экрана к сущностям.
 */
public class TracerModule extends Module {
    public TracerModule() {
        super("Tracer", "Линии от центра экрана к сущностям");
    }

    @Override
    protected void initSettings() {
        settings.put("tracerColor", 0xFF00FF00);
        settings.put("tracerWidth", 1.5f);
        settings.put("tracerFromPlayer", false);
        settings.put("maxDistance", 256.0f);
    }

    @Override
    public void onTick() {
        // Рисование трассировочных линий
    }
}
