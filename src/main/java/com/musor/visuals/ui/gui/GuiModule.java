package com.musor.visuals.ui.gui;

import net.minecraft.client.gui.GuiGraphics;
import com.musor.visuals.module.Module;

/**
 * Карточка для отображения модуля в ClickGUI.
 */
public class GuiModule {
    private Module module;
    private float x;
    private float y;
    private float width;
    private float height;
    private int cardColor = 0xFF1a0033;
    private int accentColor = 0xFF7700FF;
    private boolean expanded;

    public GuiModule(Module module, float x, float y) {
        this.module = module;
        this.x = x;
        this.y = y;
        this.width = 180;
        this.height = 25;
        this.expanded = false;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // Рисование карточки
        guiGraphics.fill((int)x, (int)y, (int)(x + width), (int)(y + height), cardColor);
        
        // Рисование акцентной линии
        if (module.isEnabled()) {
            guiGraphics.fill((int)x, (int)y, (int)x + 3, (int)(y + height), accentColor);
        }

        // Рисование текста
        guiGraphics.drawString(null, module.getName(), (int)(x + 10), (int)(y + 7), 0xFFFFFFFF, false);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            if (button == 0) {
                module.toggle();
            } else if (button == 1) {
                expanded = !expanded;
            }
        }
    }
}
