package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения моделей сквозь стены.
 */
public class ChamsModule extends Module {
    public ChamsModule() {
        super("Chams", "Отображение моделей сквозь стены");
    }

    @Override
    protected void initSettings() {
        settings.put("chamsColor", 0xFFFF00FF);
        settings.put("chamsAlpha", 0.5f);
        settings.put("showPlayers", true);
        settings.put("showFriends", false);
    }

    @Override
    public void onTick() {
        // Рендеринг с глубиной отключенной
    }
}
