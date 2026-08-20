package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения стрелок направления на игроков вне экрана.
 */
public class OffscreenArrowsModule extends Module {
    public OffscreenArrowsModule() {
        super("Offscreen Arrows", "Стрелки направления на игроков");
    }

    @Override
    protected void initSettings() {
        settings.put("arrowColor", 0xFF00FF00);
        settings.put("arrowSize", 10.0f);
        settings.put("arrowDistance", 30.0f);
    }

    @Override
    public void onTick() {
        // Рисование стрелок направления
    }
}
