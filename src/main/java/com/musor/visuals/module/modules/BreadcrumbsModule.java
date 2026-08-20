package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Модуль для отображения следа за игроком.
 */
public class BreadcrumbsModule extends Module {
    private Queue<Double[]> trail = new LinkedList<>();
    private static final int MAX_TRAIL_LENGTH = 100;

    public BreadcrumbsModule() {
        super("Breadcrumbs", "След из линий или частиц за игроком");
    }

    @Override
    protected void initSettings() {
        settings.put("trailColor", 0xFF00FF00);
        settings.put("trailWidth", 1.0f);
        settings.put("updateInterval", 2);
    }

    @Override
    public void onTick() {
        // Добавление позиций в цепь
    }
}
