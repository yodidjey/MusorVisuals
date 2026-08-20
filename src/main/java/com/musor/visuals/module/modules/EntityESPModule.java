package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import java.util.List;

/**
 * Модуль для отображения боксов вокруг игроков (2D/3D ESP).
 */
public class EntityESPModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public EntityESPModule() {
        super("Entity ESP", "Рендеринг боксов вокруг сущностей");
    }

    @Override
    protected void initSettings() {
        settings.put("show2D", true);
        settings.put("show3D", false);
        settings.put("boxWidth", 1.0f);
        settings.put("boxColor", 0xFF00FF00);
        settings.put("showPlayers", true);
        settings.put("showMobs", false);
        settings.put("maxDistance", 256.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        float maxDistance = getSettingAsFloat("maxDistance", 256.0f);
        int color = (Integer) getSetting("boxColor");
        boolean show2D = getSettingAsBoolean("show2D", true);
        boolean show3D = getSettingAsBoolean("show3D", false);

        List<Entity> entities = client.level.entitiesForRendering();
        for (Entity entity : entities) {
            if (entity == client.player) continue;
            if (entity instanceof Player && !getSettingAsBoolean("showPlayers", true)) continue;
            
            double distance = client.player.distanceTo(entity);
            if (distance > maxDistance) continue;

            if (show3D) {
                renderEntityBox3D(entity, color);
            }
            if (show2D) {
                renderEntityBox2D(entity, color);
            }
        }
    }

    private void renderEntityBox3D(Entity entity, int color) {
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        float width = entity.getBbWidth();
        float height = entity.getBbHeight();

        // Рендеринг 3D бокса
        MusorVisualsMod.renderManager.getBatcher().startBatch();
        
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 0.3f;

        MusorVisualsMod.renderManager.getBatcher().addRectangle(
            x - width / 2, y, z - width / 2,
            x + width / 2, y + height, z + width / 2,
            r, g, b, a
        );
        
        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }

    private void renderEntityBox2D(Entity entity, int color) {
        // 2D рендеринг обработается в скрин рендере
    }
}
