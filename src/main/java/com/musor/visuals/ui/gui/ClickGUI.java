package com.musor.visuals.ui.gui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Главный экран ClickGUI в фиолетовом стиле.
 * Карточки, красивые кнопки, скатегоризированные модули.
 */
public class ClickGUI extends Screen {
    private List<GuiModule> modules;
    private int backgroundColor = 0x80000000;
    private int cardColor = 0xFF1a0033;
    private int accentColor = 0xFF7700FF;

    public ClickGUI() {
        super(Component.literal("MusorVisuals ClickGUI"));
        this.modules = new ArrayList<>();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        guiGraphics.fill(0, 0, this.width, this.height, backgroundColor);

        // Рендеринг карточек модулей
        for (GuiModule module : modules) {
            module.render(guiGraphics, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
        return true;
    }

    @Override
    public void onClose() {
        super.onClose();
    }
}
