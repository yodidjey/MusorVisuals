package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class CrosshairModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public CrosshairModule() {
        super("Crosshair", "Кастомный прицел");
    }

    @Override
    protected void initSettings() {
        settings.put("crosshairType", "plus");
        settings.put("crosshairSize", 10.0f);
        settings.put("crosshairColor", 0xFFFFFFFF);
        settings.put("crosshairWidth", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Рендеринг прицела
    }
}
