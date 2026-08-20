package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class WeatherModifierModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public WeatherModifierModule() {
        super("Weather Modifier", "Отключение осадков");
    }

    @Override
    protected void initSettings() {
        settings.put("disableRain", true);
        settings.put("disableSnow", true);
        settings.put("disableThunder", true);
    }

    @Override
    public void onTick() {
        if (!enabled || client.level == null) return;
        boolean noRain = getSettingAsBoolean("disableRain", true);
        if (noRain) {
            client.level.setRainLevel(0.0f);
            client.level.setThunderLevel(0.0f);
        }
    }
}
