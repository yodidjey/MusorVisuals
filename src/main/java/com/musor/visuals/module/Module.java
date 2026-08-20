package com.musor.visuals.module;

import java.util.HashMap;
import java.util.Map;

/**
 * Базовый класс для всех визуальных модулей.
 * Обеспечивает единую архитектуру для включения/выключения, конфигурации и обновления.
 */
public abstract class Module {
    protected String name;
    protected String description;
    protected boolean enabled;
    protected int keybind;
    protected Map<String, Object> settings;

    public Module(String name, String description) {
        this.name = name;
        this.description = description;
        this.enabled = false;
        this.keybind = -1;
        this.settings = new HashMap<>();
        this.initSettings();
    }

    /**
     * Инициализирует настройки модуля.
     * Переопределяется в подклассах.
     */
    protected void initSettings() {
        // Переопределяется в подклассах
    }

    /**
     * Вызывается каждый тик, когда модуль активен.
     */
    public void onTick() {
        // Переопределяется в подклассах
    }

    /**
     * Вызывается при включении модуля.
     */
    public void onEnable() {
        // Переопределяется в подклассах
    }

    /**
     * Вызывается при отключении модуля.
     */
    public void onDisable() {
        // Переопределяется в подклассах
    }

    /**
     * Загружает конфигурацию модуля.
     */
    public void loadConfig() {
        // Переопределяется в подклассах
    }

    /**
     * Сохраняет конфигурацию модуля.
     */
    public void saveConfig() {
        // Переопределяется в подклассах
    }

    /**
     * Переключает модуль вкл/выкл.
     */
    public void toggle() {
        setEnabled(!enabled);
    }

    /**
     * Устанавливает состояние модуля.
     */
    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    /**
     * Устанавливает настройку модуля.
     */
    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }

    /**
     * Получает настройку модуля.
     */
    public Object getSetting(String key) {
        return settings.getOrDefault(key, null);
    }

    /**
     * Получает настройку как float.
     */
    public float getSettingAsFloat(String key, float defaultValue) {
        Object value = settings.get(key);
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        return defaultValue;
    }

    /**
     * Получает настройку как boolean.
     */
    public boolean getSettingAsBoolean(String key, boolean defaultValue) {
        Object value = settings.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return defaultValue;
    }

    // Геттеры

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getKeybind() {
        return keybind;
    }

    public void setKeybind(int keybind) {
        this.keybind = keybind;
    }

    public Map<String, Object> getSettings() {
        return new HashMap<>(settings);
    }
}
