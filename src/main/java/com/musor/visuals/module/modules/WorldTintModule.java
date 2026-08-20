package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class WorldTintModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public WorldTintModule() {
        super("World Tint", "Тонирование блоков и мира");
    }

    @Override
    protected void initSettings() {
        settings.put("tintRed", 1.0f);
        settings.put("tintGreen", 1.0f);
        settings.put("tintBlue", 1.0f);
        settings.put("tintAlpha", 0.5f);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Тонирование мира
    }
}
