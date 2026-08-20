package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения скелета игрока/моба.
 */
public class SkeletonESPModule extends Module {
    public SkeletonESPModule() {
        super("Skeleton ESP", "Рендеринг скелета игрока");
    }

    @Override
    protected void initSettings() {
        settings.put("skeletonColor", 0xFF00FFFF);
        settings.put("skeletonWidth", 2.0f);
        settings.put("showJoints", true);
    }

    @Override
    public void onTick() {
        // Рисование костей скелета
    }
}
