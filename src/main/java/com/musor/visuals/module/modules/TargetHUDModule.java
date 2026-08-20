package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class TargetHUDModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private TargetESPModule targetModule;

    public TargetHUDModule() {
        super("Target HUD", "Панель с инфо о цели");
    }

    @Override
    protected void initSettings() {
        settings.put("hudX", 10.0f);
        settings.put("hudY", 10.0f);
        settings.put("hudWidth", 200.0f);
        settings.put("hudHeight", 100.0f);
        settings.put("backgroundColor", 0x80000000);
        settings.put("showSkin", true);
        settings.put("showHealth", true);
        settings.put("showArmor", true);
        settings.put("showPing", true);
    }

    @Override
    public void onTick() {
        if (!enabled) return;
        targetModule = (TargetESPModule) null; // Получить из менеджера
    }
}
