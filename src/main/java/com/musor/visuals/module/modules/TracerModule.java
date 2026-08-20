package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * Модуль для рисования линий от центра экрана к сущностям.
 */
public class TracerModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public TracerModule() {
        super("Tracer", "Линии от центра экрана к сущностям");
    }

    @Override
    protected void initSettings() {
        settings.put("tracerColor", 0xFF00FF00);
        settings.put("tracerWidth", 1.5f);
        settings.put("tracerFromPlayer", false);
        settings.put("maxDistance", 256.0f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("tracerColor");
        float width = getSettingAsFloat("tracerWidth", 1.5f);
        float maxDistance = getSettingAsFloat("maxDistance", 256.0f);
        boolean fromPlayer = getSettingAsBoolean("tracerFromPlayer", false);

        MusorVisualsMod.renderManager.getBatcher().startBatch();
        
        Vec3 startPos = fromPlayer ? 
            client.player.position().add(0, client.player.getEyeHeight(), 0) :
            new Vec3(client.gameRenderer.getCamera().getPosition().x, 
                    client.gameRenderer.getCamera().getPosition().y,
                    client.gameRenderer.getCamera().getPosition().z);

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;
            if (entity.distanceTo(client.player) > maxDistance) continue;

            Vec3 endPos = entity.position().add(0, entity.getEyeHeight(), 0);
            
            float r = ((color >> 16) & 0xFF) / 255.0f;
            float g = ((color >> 8) & 0xFF) / 255.0f;
            float b = (color & 0xFF) / 255.0f;
            float a = 0.7f;

            MusorVisualsMod.renderManager.getBatcher().addLine(
                startPos.x, startPos.y, startPos.z,
                endPos.x, endPos.y, endPos.z,
                r, g, b, a, width
            );
        }
        
        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
