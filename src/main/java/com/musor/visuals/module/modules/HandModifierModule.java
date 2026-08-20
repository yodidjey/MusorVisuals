package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class HandModifierModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public HandModifierModule() {
        super("Hand Modifier", "Изменение положения рук и предметов");
    }

    @Override
    protected void initSettings() {
        settings.put("handOffsetX", 0.0f);
        settings.put("handOffsetY", 0.0f);
        settings.put("handScale", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Модификация положения рук
    }
}
