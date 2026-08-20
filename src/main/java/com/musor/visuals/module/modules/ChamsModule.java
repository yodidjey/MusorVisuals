package com.musor.visuals.module.modules;

import com.musor.visuals.module.Module;
import com.musor.visuals.MusorVisualsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.opengl.GL11;

/**
 * Модуль для отображения моделей сквозь стены (Chams).
 */
public class ChamsModule extends Module {
    private Minecraft client = Minecraft.getInstance();

    public ChamsModule() {
        super("Chams", "Отображение моделей сквозь стены");
    }

    @Override
    protected void initSettings() {
        settings.put("chamsColor", 0xFFFF00FF);
        settings.put("chamsAlpha", 0.5f);
        settings.put("showPlayers", true);
        settings.put("showFriends", false);
    }

    @Override
    public void onTick() {
        if (!enabled || client.player == null || client.level == null) return;

        int color = (Integer) getSetting("chamsColor");
        float alpha = getSettingAsFloat("chamsAlpha", 0.5f);
        boolean showPlayers = getSettingAsBoolean("showPlayers", true);

        // Отключаем тест глубины
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        
        for (Entity entity : client.level.entitiesForRendering()) {
            if (entity == client.player) continue;
            if (entity instanceof Player && !showPlayers) continue;

            // Применяем цвет к сущности
            float r = ((color >> 16) & 0xFF) / 255.0f;
            float g = ((color >> 8) & 0xFF) / 255.0f;
            float b = (color & 0xFF) / 255.0f;
            
            // Рендеринг с цветом
            GL11.glColor4f(r, g, b, alpha);
        }
        
        // Восстанавливаем состояние
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
