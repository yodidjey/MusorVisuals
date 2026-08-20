package com.musor.visuals.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.musor.visuals.MusorVisualsMod;

/**
 * Система управления конфигурацией модификации.
 * Обеспечивает сохранение и загрузку настроек из JSON файла.
 */
public class ConfigManager {
    private static final String CONFIG_DIR = "MusorVisuals";
    private static final String CONFIG_FILE = "config.json";
    
    private Path configPath;
    private JsonObject config;
    private Gson gson;

    public ConfigManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.initializePaths();
    }

    /**
     * Инициализирует пути к конфигурационному файлу.
     */
    private void initializePaths() {
        String userHome = System.getProperty("user.home");
        Path basePath = Paths.get(userHome, ".minecraft", "config", CONFIG_DIR);
        
        try {
            Files.createDirectories(basePath);
            this.configPath = basePath.resolve(CONFIG_FILE);
        } catch (Exception e) {
            MusorVisualsMod.LOGGER.error("Failed to initialize config paths", e);
        }
    }

    /**
     * Загружает конфигурацию из файла.
     */
    public void loadConfig() {
        try {
            if (Files.exists(configPath)) {
                FileReader reader = new FileReader(configPath.toFile());
                config = gson.fromJson(reader, JsonObject.class);
                reader.close();
                MusorVisualsMod.LOGGER.info("Config loaded successfully");
            } else {
                config = new JsonObject();
                saveConfig();
                MusorVisualsMod.LOGGER.info("New config created");
            }
        } catch (Exception e) {
            MusorVisualsMod.LOGGER.error("Failed to load config", e);
            config = new JsonObject();
        }
    }

    /**
     * Сохраняет конфигурацию в файл.
     */
    public void saveConfig() {
        try {
            FileWriter writer = new FileWriter(configPath.toFile());
            gson.toJson(config, writer);
            writer.close();
            MusorVisualsMod.LOGGER.info("Config saved successfully");
        } catch (Exception e) {
            MusorVisualsMod.LOGGER.error("Failed to save config", e);
        }
    }

    public JsonObject getConfig() {
        return config;
    }

    public void setProperty(String key, Object value) {
        if (value instanceof String) {
            config.addProperty(key, (String) value);
        } else if (value instanceof Number) {
            config.addProperty(key, (Number) value);
        } else if (value instanceof Boolean) {
            config.addProperty(key, (Boolean) value);
        }
        saveConfig();
    }

    public Object getProperty(String key, Object defaultValue) {
        if (config.has(key)) {
            return config.get(key);
        }
        return defaultValue;
    }
}
