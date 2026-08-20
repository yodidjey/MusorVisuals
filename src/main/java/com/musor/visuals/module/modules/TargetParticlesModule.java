package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для частиц, кружащихся вокруг цели.
 */
public class TargetParticlesModule extends Module {
    public TargetParticlesModule() {
        super("Target Particles", "Частицы, кружащиеся вокруг цели");
    }

    @Override
    protected void initSettings() {
        settings.put("particleColor", 0xFFFF0000);
        settings.put("particleCount", 8);
        settings.put("orbitRadius", 1.0f);
        settings.put("rotationSpeed", 0.3f);
    }

    @Override
    public void onTick() {
        // Рендеринг орбитальных частиц
    }
}
