package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;

public class CooldownBarModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public CooldownBarModule() {
        super("Cooldown Bar", "Индикатор перезарядки атаки");
    }

    @Override
    protected void initSettings() {
        settings.put("cooldownX", 10.0f);
        settings.put("cooldownY", 80.0f);
        settings.put("cooldownWidth", 100.0f);
        settings.put("cooldownHeight", 10.0f);
        settings.put("barColor", 0xFF00FF00);
        settings.put("backgroundColor", 0x80000000);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        float cooldown = client.player.getAttackStrengthScale(0);
        // Рендеринг индикатора
    }
}
