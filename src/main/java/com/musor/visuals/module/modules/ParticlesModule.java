package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import java.util.Random;

/**
 * Модуль для спавна кастомных частиц.
 */
public class ParticlesModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private Random random = new Random();
    private Entity lastDamagedEntity;

    public ParticlesModule() {
        super("Particles", "Спавн кастомных частиц при ударах/ходьбе");
    }

    @Override
    protected void initSettings() {
        settings.put("particleColor", 0xFF00FF00);
        settings.put("particleCount", 5);
        settings.put("particleSpeed", 0.5f);
        settings.put("onHit", true);
        settings.put("onStep", false);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("particleColor");
        int count = ((Number) getSetting("particleCount")).intValue();
        float speed = getSettingAsFloat("particleSpeed", 0.5f);
        boolean onHit = getSettingAsBoolean("onHit", true);

        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 1.0f;

        if (onHit && client.player.getAttackStrengthScale(0) > 0.9f) {
            // Спавним частицы при ударе
            Vec3 playerPos = client.player.position();
            spawnParticles(playerPos, count, speed, r, g, b, a);
        }
    }

    private void spawnParticles(Vec3 center, int count, float speed, float r, float g, float b, float a) {
        MusorVisualsMod.renderManager.getBatcher().startBatch();

        for (int i = 0; i < count; i++) {
            double angle = random.nextDouble() * Math.PI * 2;
            double vx = Math.cos(angle) * speed;
            double vz = Math.sin(angle) * speed;

            Vec3 particlePos = center.add(vx, random.nextDouble() * 0.5, vz);
            // Рендеринг частицы
        }

        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
