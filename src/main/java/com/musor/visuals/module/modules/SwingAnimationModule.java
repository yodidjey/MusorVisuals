package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class SwingAnimationModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public SwingAnimationModule() {
        super("Swing Animation", "Кастомные анимации удара/взмаха");
    }

    @Override
    protected void initSettings() {
        settings.put("swingSpeed", 1.0f);
        settings.put("animationType", "default");
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        // Модификация анимаций
    }
}
