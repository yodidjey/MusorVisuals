package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class CustomSkyModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public CustomSkyModule() {
        super("Custom Sky", "Кастомизация неба, звезд и луны");
    }

    @Override
    protected void initSettings() {
        settings.put("customStars", true);
        settings.put("customMoon", true);
        settings.put("moonScale", 1.0f);
        settings.put("starBrightness", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Модификация неба
    }
}
