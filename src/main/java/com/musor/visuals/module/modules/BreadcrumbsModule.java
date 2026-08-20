package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Модуль для отображения следа за игроком.
 */
public class BreadcrumbsModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Queue<Vec3> trail = new LinkedList<>();
    private static final int MAX_TRAIL_LENGTH = 100;
    private int updateCounter = 0;

    public BreadcrumbsModule() {
        super("Breadcrumbs", "След из линий или частиц за игроком");
    }

    @Override
    protected void initSettings() {
        settings.put("trailColor", 0xFF00FF00);
        settings.put("trailWidth", 1.0f);
        settings.put("updateInterval", 2);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int updateInterval = ((Number) getSetting("updateInterval")).intValue();
        updateCounter++;

        if (updateCounter % updateInterval == 0) {
            trail.offer(client.player.position());
            if (trail.size() > MAX_TRAIL_LENGTH) {
                trail.poll();
            }
        }

        int color = (Integer) getSetting("trailColor");
        float width = getSettingAsFloat("trailWidth", 1.0f);

        MusorVisualsMod.renderManager.getBatcher().startBatch();

        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 0.5f;

        Vec3[] trailPoints = trail.toArray(new Vec3[0]);
        for (int i = 0; i < trailPoints.length - 1; i++) {
            Vec3 from = trailPoints[i];
            Vec3 to = trailPoints[i + 1];

            MusorVisualsMod.renderManager.getBatcher().addLine(
                from.x, from.y, from.z,
                to.x, to.y, to.z,
                r, g, b, a, width
            );
        }

        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
