package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;

/**
 * Модуль для отображения расходящихся кругов при прыжке.
 */
public class JumpCirclesModule extends Module {
    public JumpCirclesModule() {
        super("Jump Circles", "Расходящиеся круги на земле при прыжке");
    }

    @Override
    protected void initSettings() {
        settings.put("circleColor", 0xFF00FF00);
        settings.put("circleSpeed", 0.5f);
        settings.put("maxRadius", 5.0f);
    }

    @Override
    public void onTick() {
        // Рендеринг кругов
    }
}
