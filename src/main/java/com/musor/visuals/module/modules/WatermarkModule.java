package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class WatermarkModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private long startTime = System.currentTimeMillis();

    public WatermarkModule() {
        super("Watermark", "Логотип и название клиента");
    }

    @Override
    protected void initSettings() {
        settings.put("watermarkX", 10.0f);
        settings.put("watermarkY", 10.0f);
        settings.put("textColor", 0xFFFFFFFF);
        settings.put("showFPS", true);
        settings.put("showPing", true);
        settings.put("textScale", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Рендеринг в экран обработчике
    }
}
