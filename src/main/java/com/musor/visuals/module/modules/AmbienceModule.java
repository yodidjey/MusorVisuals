package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;

public class AmbienceModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public AmbienceModule() {
        super("Ambience", "Изменение времени суток и цвета неба");
    }

    @Override
    protected void initSettings() {
        settings.put("time", 6000.0f);
        settings.put("skyRed", 1.0f);
        settings.put("skyGreen", 1.0f);
        settings.put("skyBlue", 1.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.level == null) return;
        float time = getSettingAsFloat("time", 6000.0f);
        // Установка времени суток
    }
}
