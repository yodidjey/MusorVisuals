package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения боксов вокруг игроков (2D/3D ESP).
 */
public class EntityESPModule extends Module {
    public EntityESPModule() {
        super("Entity ESP", "Рендеринг боксов вокруг сущностей");
    }

    @Override
    protected void initSettings() {
        settings.put("show2D", true);
        settings.put("show3D", false);
        settings.put("boxWidth", 1.0f);
        settings.put("boxColor", 0xFF00FF00);
        settings.put("showPlayers", true);
        settings.put("showMobs", false);
        settings.put("maxDistance", 256.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг боксов вокруг видимых сущностей
    }
}
