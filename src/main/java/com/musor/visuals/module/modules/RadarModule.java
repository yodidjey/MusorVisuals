package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class RadarModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private float radarRotation = 0;

    public RadarModule() {
        super("Radar", "Миникарта/радар с отображением игроков");
    }

    @Override
    protected void initSettings() {
        settings.put("radarX", 10.0f);
        settings.put("radarY", 10.0f);
        settings.put("radarSize", 100.0f);
        settings.put("radarScale", 1.0f);
        settings.put("backgroundColor", 0x80000000);
        settings.put("playerColor", 0xFF00FF00);
        settings.put("enemyColor", 0xFFFF0000);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        radarRotation += 1;
        // Рендеринг радара
    }
}
