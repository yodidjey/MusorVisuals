package com.musor.visuals.ui.components;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Красивый слайдер для изменения параметров.
 */
public class Slider {
    private float x;
    private float y;
    private float width;
    private float height;
    private float minValue;
    private float maxValue;
    private float currentValue;
    private String label;
    private int sliderColor = 0xFF7700FF;
    private int backgroundColor = 0xFF1a0033;
    private boolean dragging;

    public Slider(float x, float y, float width, float height, float minValue, float maxValue, float defaultValue, String label) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = defaultValue;
        this.label = label;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // Рисование фона
        guiGraphics.fill((int)x, (int)y, (int)(x + width), (int)(y + height), backgroundColor);
        
        // Рисование прогресса
        float progress = (currentValue - minValue) / (maxValue - minValue);
        guiGraphics.fill((int)x, (int)y, (int)(x + width * progress), (int)(y + height), sliderColor);
        
        // Рисование текста
        guiGraphics.drawString(null, label + ": " + String.format("%.2f", currentValue), (int)(x + 5), (int)(y + height / 2 - 4), 0xFFFFFFFF, false);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            dragging = true;
            updateValue(mouseX);
        }
    }

    public void mouseDragged(double mouseX, double mouseY) {
        if (dragging) {
            updateValue(mouseX);
        }
    }

    public void mouseReleased() {
        dragging = false;
    }

    private void updateValue(double mouseX) {
        float ratio = (float) ((mouseX - x) / width);
        currentValue = minValue + (maxValue - minValue) * Math.max(0, Math.min(1, ratio));
    }

    public float getValue() {
        return currentValue;
    }
}
