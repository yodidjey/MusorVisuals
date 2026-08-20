package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для кастомных анимаций удара.
 */
public class SwingAnimationModule extends Module {
    public SwingAnimationModule() {
        super("Swing Animation", "Кастомные анимации удара/взмаха");
    }

    @Override
    protected void initSettings() {
        settings.put("swingSpeed", 1.0f);
        settings.put("animationType", "default");
    }

    @Override
    public void onTick() {
        // Модификация анимаций
    }
}
