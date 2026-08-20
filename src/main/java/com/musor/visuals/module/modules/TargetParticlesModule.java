package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import java.util.ArrayList;
import java.util.List;

/**
 * Модуль для частиц, кружащихся вокруг цели.
 */
public class TargetParticlesModule extends Module {
    private Minecraft client = Minecraft.getInstance();
    private List<Float> particleAngles = new ArrayList<>();

    public TargetParticlesModule() {
        super("Target Particles", "Частицы, кружащиеся вокруг цели");
    }

    @Override
    protected void initSettings() {
        settings.put("particleColor", 0xFFFF0000);
        settings.put("particleCount", 8);
        settings.put("orbitRadius", 1.0f);
        settings.put("rotationSpeed", 0.3f);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        // Получаем текущую цель из TargetESPModule
        TargetESPModule targetModule = (TargetESPModule) MusorVisualsMod.moduleManager.getModule("Target ESP");
        if (targetModule == null || targetModule.getCurrentTarget() == null) return;

        int color = (Integer) getSetting("particleColor");
        int count = ((Number) getSetting("particleCount")).intValue();
        float radius = getSettingAsFloat("orbitRadius", 1.0f);
        float speed = getSettingAsFloat("rotationSpeed", 0.3f);

        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 1.0f;

        MusorVisualsMod.renderManager.getBatcher().startBatch();

        Vec3 targetPos = targetModule.getCurrentTarget().position()
            .add(0, targetModule.getCurrentTarget().getBbHeight() / 2, 0);

        for (int i = 0; i < count; i++) {
            float angle = (i / (float) count) * (float) (Math.PI * 2);
            angle += speed;

            double px = targetPos.x + Math.cos(angle) * radius;
            double py = targetPos.y;
            double pz = targetPos.z + Math.sin(angle) * radius;

            // Рендеринг частицы
            MusorVisualsMod.renderManager.getBatcher().addCircle(
                px, py, pz, 0.2f, r, g, b, a, 8
            );
        }

        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
