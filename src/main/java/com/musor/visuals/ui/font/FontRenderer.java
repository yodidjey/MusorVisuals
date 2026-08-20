package com.musor.visuals.ui.font;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Кастомный рендерер шрифтов в стиле EspressoDolce.
 * Поддерживает различные стили, размеры и цвета.
 */
public class FontRenderer {
    private String fontName;
    private float scale;
    private int color;

    public FontRenderer(String fontName, float scale, int color) {
        this.fontName = fontName;
        this.scale = scale;
        this.color = color;
    }

    /**
     * Рисует текст в стиле EspressoDolce.
     */
    public void drawString(GuiGraphics guiGraphics, String text, float x, float y) {
        // Отрисовка кастомного шрифта
    }

    /**
     * Рисует текст с тенью.
     */
    public void drawStringWithShadow(GuiGraphics guiGraphics, String text, float x, float y) {
        // Отрисовка с тенью
    }

    /**
     * Рисует центрированный текст.
     */
    public void drawCenteredString(GuiGraphics guiGraphics, String text, float x, float y) {
        // Отрисовка центрированного текста
    }
}
