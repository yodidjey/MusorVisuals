package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для спавна кастомных частиц.
 */
public class ParticlesModule extends Module {
    public ParticlesModule() {
        super("Particles", "Спавн кастомных частиц при ударах/ходьбе");
    }

    @Override
    protected void initSettings() {
        settings.put("particleColor", 0xFF00FF00);
        settings.put("particleCount", 5);
        settings.put("particleSpeed", 0.5f);
        settings.put("onHit", true);
        settings.put("onStep", false);
    }

    @Override
    public void onTick() {
        // Спавн частиц
    }
}
