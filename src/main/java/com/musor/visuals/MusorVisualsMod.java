package com.musor.visuals;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musor.visuals.config.ConfigManager;
import com.musor.visuals.render.RenderManager;
import com.musor.visuals.module.ModuleManager;
import com.musor.visuals.ui.gui.ClickGUI;

public class MusorVisualsMod implements ClientModInitializer {
    public static final String MOD_ID = "musorvisuals";
    public static final String MOD_NAME = "MusorVisuals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static MusorVisualsMod INSTANCE;
    public static ConfigManager configManager;
    public static RenderManager renderManager;
    public static ModuleManager moduleManager;
    public static ClickGUI clickGUI;

    public MusorVisualsMod() {
        INSTANCE = this;
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing {} v1.0.0", MOD_NAME);
        
        // Инициализация системы конфигурации
        configManager = new ConfigManager();
        configManager.loadConfig();

        // Инициализация системы рендеринга
        renderManager = new RenderManager();

        // Инициализация системы модулей
        moduleManager = new ModuleManager();
        moduleManager.registerAllModules();

        // Инициализация ClickGUI
        clickGUI = new ClickGUI();

        // Регистрация обработчиков событий
        WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> renderManager.onWorldRender(context));
        ClientTickEvents.END_CLIENT_TICK.register(client -> moduleManager.onTick());

        LOGGER.info("{} loaded successfully!", MOD_NAME);
    }
}
