package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для стилизации таблицы счета.
 */
public class ScoreboardCustomizerModule extends Module {
    public ScoreboardCustomizerModule() {
        super("Scoreboard Customizer", "Стилизация и перемещение таблицы счета");
    }

    @Override
    protected void initSettings() {
        settings.put("scoreboardX", 0.0f);
        settings.put("scoreboardY", 0.0f);
        settings.put("backgroundColor", 0x80000000);
        settings.put("textColor", 0xFFFFFFFF);
        settings.put("scale", 1.0f);
    }

    @Override
    public void onTick() {
        // Перемещение и стилизация скорборда
    }
}
