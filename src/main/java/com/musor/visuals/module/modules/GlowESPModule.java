package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import com.musor.visuals.util.color.ColorUtils;

/**
 * Модуль для свечения контуров сущностей.
 */
public class GlowESPModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public GlowESPModule() {
        super("Glow ESP", "Свечение контуров сущностей");
    }

    @Override
    protected void initSettings() {
        settings.put("glowColor", 0xFF00FF00);
        settings.put("glowIntensity", 1.0f);
        settings.put("outlineWidth", 2.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("glowColor");
        float intensity = getSettingAsFloat("glowIntensity", 1.0f);
        float outlineWidth = getSettingAsFloat("outlineWidth", 2.0f);

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;
            
            // Применяем эффект свечения к сущности
            int glowColor = ColorUtils.withAlpha(color, intensity);
            entity.setGlowingTag(true);
        }
    }

    @Override
    public void onDisable() {
        if (client.level != null) {
            for (Entity entity : client.level.entitiesForRendering()) {
                entity.setGlowingTag(false);
            }
        }
    }
}
