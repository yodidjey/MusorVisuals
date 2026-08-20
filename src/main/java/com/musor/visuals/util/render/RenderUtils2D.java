package com.musor.visuals.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

/**
 * Утилиты для отрисовки 2D элементов на экране.
 * Поддерживает рисование линий, прямоугольников, окружностей и т.д.
 */
public class RenderUtils2D {
    private static final Minecraft client = Minecraft.getInstance();

    /**
     * Рисует прямоугольник на экране.
     */
    public static void drawRect(PoseStack poseStack, float x, float y, float width, float height, int color) {
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        float a = ((color >> 24) & 0xFF) / 255.0f;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        // Рисование прямоугольника
    }

    /**
     * Рисует границу прямоугольника.
     */
    public static void drawBorder(PoseStack poseStack, float x, float y, float width, float height, float borderWidth, int color) {
        // Верхняя граница
        drawRect(poseStack, x, y, width, borderWidth, color);
        // Нижняя граница
        drawRect(poseStack, x, y + height - borderWidth, width, borderWidth, color);
        // Левая граница
        drawRect(poseStack, x, y, borderWidth, height, color);
        // Правая граница
        drawRect(poseStack, x + width - borderWidth, y, borderWidth, height, color);
    }

    /**
     * Рисует окружность на экране.
     */
    public static void drawCircle(PoseStack poseStack, float centerX, float centerY, float radius, int color) {
        // Рисование окружности
    }

    /**
     * Рисует заполненный треугольник.
     */
    public static void drawTriangle(PoseStack poseStack, float x1, float y1, float x2, float y2, float x3, float y3, int color) {
        // Рисование треугольника
    }
}
