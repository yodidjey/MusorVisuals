package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import java.util.HashMap;
import java.util.Map;

/**
 * Модуль для отображения расходящихся кругов при прыжке.
 */
public class JumpCirclesModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Map<Integer, Float> jumpCircles = new HashMap<>(); // Entity ID ->Radius
    private int lastYPosition = 0;

    public JumpCirclesModule() {
        super("Jump Circles", "Расходящиеся круги на земле при прыжке");
    }

    @Override
    protected void initSettings() {
        settings.put("circleColor", 0xFF00FF00);
        settings.put("circleSpeed", 0.5f);
        settings.put("maxRadius", 5.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("circleColor");
        float speed = getSettingAsFloat("circleSpeed", 0.5f);
        float maxRadius = getSettingAsFloat("maxRadius", 5.0f);

        // Проверяем если игрок прыгнул
        int currentY = (int) client.player.getY();
        if (currentY > lastYPosition && !client.player.isOnGround()) {
            Vec3 playerPos = client.player.position();
            jumpCircles.put(0, 0.1f);
        }
        lastYPosition = currentY;

        MusorVisualsMod.renderManager.getBatcher().startBatch();

        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;

            Integer id = entity.getId();
            if (jumpCircles.containsKey(id)) {
                float radius = jumpCircles.get(id);
                radius += speed;

                if (radius > maxRadius) {
                    jumpCircles.remove(id);
                } else {
                    jumpCircles.put(id, radius);
                    float alpha = 1.0f - (radius / maxRadius);

                    Vec3 pos = entity.position();
                    MusorVisualsMod.renderManager.getBatcher().addCircle(
                        pos.x, pos.y, pos.z, radius, r, g, b, alpha, 32
                    );
                }
            }
        }

        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
