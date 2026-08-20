package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

/**
 * Модуль для отображения скелета игрока/моба.
 */
public class SkeletonESPModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public SkeletonESPModule() {
        super("Skeleton ESP", "Рендеринг скелета игрока");
    }

    @Override
    protected void initSettings() {
        settings.put("skeletonColor", 0xFF00FFFF);
        settings.put("skeletonWidth", 2.0f);
        settings.put("showJoints", true);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("skeletonColor");
        float width = getSettingAsFloat("skeletonWidth", 2.0f);
        boolean showJoints = getSettingAsBoolean("showJoints", true);

        MusorVisualsMod.renderManager.getBatcher().startBatch();
        
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = 1.0f;

        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;
            if (!(entity instanceof LivingEntity)) continue;

            LivingEntity living = (LivingEntity) entity;
            Vec3 headPos = new Vec3(entity.getX(), entity.getY() + entity.getEyeHeight(), entity.getZ());
            Vec3 bodyPos = entity.position().add(0, entity.getBbHeight() * 0.5, 0);
            Vec3 legPos = entity.position();

            // Рисуем кости скелета
            MusorVisualsMod.renderManager.getBatcher().addLine(
                headPos.x, headPos.y, headPos.z,
                bodyPos.x, bodyPos.y, bodyPos.z,
                r, g, b, a, width
            );

            MusorVisualsMod.renderManager.getBatcher().addLine(
                bodyPos.x, bodyPos.y, bodyPos.z,
                legPos.x, legPos.y, legPos.z,
                r, g, b, a, width
            );
        }
        
        MusorVisualsMod.renderManager.getBatcher().endBatch();
    }
}
