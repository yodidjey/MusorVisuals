package com.musor.visuals.ui.components;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Красивая кнопка для ClickGUI.
 */
public class Button {
    private float x;
    private float y;
    private float width;
    private float height;
    private String label;
    private int backgroundColor = 0xFF1a0033;
    private int hoverColor = 0xFF7700FF;
    private Runnable onClick;
    private boolean hovered;

    public Button(float x, float y, float width, float height, String label, Runnable onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.onClick = onClick;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        int color = hovered ? hoverColor : backgroundColor;
        
        // Рисование фона кнопки
        guiGraphics.fill((int)x, (int)y, (int)(x + width), (int)(y + height), color);
        
        // Рисование границы
        guiGraphics.fill((int)x, (int)y, (int)(x + width), (int)y + 1, 0xFF7700FF);
        
        // Рисование текста
        guiGraphics.drawCenteredString(null, label, (int)(x + width / 2), (int)(y + height / 2 - 4), 0xFFFFFFFF, false);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (hovered && button == 0) {
            onClick.run();
        }
    }
}
