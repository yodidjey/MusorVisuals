package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.Mth;

/**
 * Модуль для отображения конуса/шляпы над головой игрока.
 */
public class ChinaHatModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private float rotation = 0;

    public ChinaHatModule() {
        super("China Hat", "Конус над головой игрока");
    }

    @Override
    protected void initSettings() {
        settings.put("hatColor", 0xFFFF00FF);
        settings.put("hatSize", 0.5f);
        settings.put("hatHeight", 2.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("hatColor");
        float size = getSettingAsFloat("hatSize", 0.5f);
        float height = getSettingAsFloat("hatHeight", 2.0f);

        rotation += 5; // Вращение конуса
        if (rotation >= 360) rotation = 0;

        MusorVisualsMod.renderManager.getBatcher().startBatch();

        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 0.7f;

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;

            Vec3 hatTop = entity.position().add(0, entity.getBbHeight() + height, 0);
            Vec3 hatBase = entity.position().add(0, entity.getBbHeight(), 0);

            // Рендеринг конуса
            MusorVisualsMod.renderManager.getBatcher().addCircle(
                hatBase.x, hatBase.y, hatBase.z, size, r, g, b, a, 16
            );
        }

        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
