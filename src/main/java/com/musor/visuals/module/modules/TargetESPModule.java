package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * Модуль для отображения линий здоровья на цели.
 */
public class TargetESPModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Entity currentTarget;

    public TargetESPModule() {
        super("Target ESP", "Указатель на текущую цель");
    }

    @Override
    protected void initSettings() {
        settings.put("markColor", 0xFFFF0000);
        settings.put("markSize", 5.0f);
        settings.put("markType", "circle");
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null) return;

        // Найти ближайшую цель
        Entity closest = null;
        double closestDistance = Double.MAX_VALUE;

        if (client.level != null) {
            for (Entity entity : client.level.entitiesForRendering()) {
                if (entity == client.player) continue;
                double distance = client.player.distanceTo(entity);
                if (distance < closestDistance) {
                    closest = entity;
                    closestDistance = distance;
                }
            }
        }

        currentTarget = closest;

        if (currentTarget != null) {
            int color = (Integer) getSetting("markColor");
            float size = getSettingAsFloat("markSize", 5.0f);
            String type = (String) getSetting("markType");

            Vec3 targetPos = currentTarget.position().add(0, currentTarget.getEyeHeight() / 2, 0);
            renderTargetMarker(targetPos, size, color, type);
        }
    }

    private void renderTargetMarker(Vec3 pos, float size, int color, String type) {
        // Рендеринг маркера цели
        MusorVisualsMod.renderManager.getBatcher().startBatch();
        
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 1.0f;

        if (type.equals("circle")) {
            MusorVisualsMod.renderManager.getBatcher().addCircle(
                pos.x, pos.y, pos.z, size, r, g, b, a, 32
            );
        }
        
        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }

    public Entity getCurrentTarget() {
        return currentTarget;
    }
}
