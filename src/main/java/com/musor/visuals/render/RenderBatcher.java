package com.musor.visuals.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.lwjgl.opengl.GL11;

/**
 * Система батчинга для оптимизации рендеринга.
 * Минимизирует вызовы OpenGL и максимизирует производительность.
 */
public class RenderBatcher {
    private Tesselator tesselator;
    private BufferBuilder buffer;
    private boolean isDrawing;

    public RenderBatcher() {
        this.tesselator = Tesselator.getInstance();
        this.buffer = tesselator.getBuilder();
        this.isDrawing = false;
    }

    /**
     * Начинает батч рендеринга.
     */
    public void startBatch() {
        if (isDrawing) return;
        RenderSystem.assertOnRenderThread();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        isDrawing = true;
    }

    /**
     * Заканчивает батч и выполняет отрисовку на GPU.
     */
    public void endBatch() {
        if (!isDrawing) return;
        RenderSystem.assertOnRenderThread();
        tesselator.end();
        isDrawing = false;
    }

    /**
     * Добавляет прямоугольник в батч.
     * Оптимизировано для рисования боксов ESP.
     */
    public void addRectangle(double x1, double y1, double z1, double x2, double y2, double z2, 
                             float r, float g, float b, float a) {
        if (!isDrawing) return;

        // Передние и задние грани
        addQuad(x1, y1, z1, x2, y1, z1, x2, y2, z1, x1, y2, z1, r, g, b, a);
        addQuad(x2, y1, z2, x1, y1, z2, x1, y2, z2, x2, y2, z2, r, g, b, a);

        // Левая и правая грани
        addQuad(x1, y1, z2, x1, y1, z1, x1, y2, z1, x1, y2, z2, r, g, b, a);
        addQuad(x2, y1, z1, x2, y1, z2, x2, y2, z2, x2, y2, z1, r, g, b, a);

        // Верхняя и нижняя грани
        addQuad(x1, y1, z1, x2, y1, z1, x2, y1, z2, x1, y1, z2, r, g, b, a);
        addQuad(x2, y2, z1, x1, y2, z1, x1, y2, z2, x2, y2, z2, r, g, b, a);
    }

    /**
     * Добавляет четырёхугольник в батч.
     */
    private void addQuad(double x1, double y1, double z1, double x2, double y2, double z2,
                         double x3, double y3, double z3, double x4, double y4, double z4,
                         float r, float g, float b, float a) {
        buffer.vertex(x1, y1, z1).color(r, g, b, a).endVertex();
        buffer.vertex(x2, y2, z2).color(r, g, b, a).endVertex();
        buffer.vertex(x3, y3, z3).color(r, g, b, a).endVertex();
        buffer.vertex(x4, y4, z4).color(r, g, b, a).endVertex();
    }

    /**
     * Добавляет линию в батч (для трассировки, линий здоровья и т.д.).
     */
    public void addLine(double x1, double y1, double z1, double x2, double y2, double z2,
                        float r, float g, float b, float a, float width) {
        if (!isDrawing) return;
        
        RenderSystem.lineWidth(width);
        buffer.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR);
        buffer.vertex(x1, y1, z1).color(r, g, b, a).endVertex();
        buffer.vertex(x2, y2, z2).color(r, g, b, a).endVertex();
        tesselator.end();
    }

    /**
     * Добавляет окружность в батч.
     */
    public void addCircle(double centerX, double centerY, double centerZ, double radius,
                          float r, float g, float b, float a, int segments) {
        if (!isDrawing) return;

        buffer.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
        buffer.vertex(centerX, centerY, centerZ).color(r, g, b, a).endVertex();

        for (int i = 0; i <= segments; i++) {
            double angle = (2.0D * Math.PI * i) / segments;
            double x = centerX + radius * Math.cos(angle);
            double z = centerZ + radius * Math.sin(angle);
            buffer.vertex(x, centerY, z).color(r, g, b, a).endVertex();
        }

        tesselator.end();
    }

    public boolean isDrawing() {
        return isDrawing;
    }
}
