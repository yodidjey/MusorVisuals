package com.musor.visuals.util.color;

import java.awt.Color;

/**
 * Утилиты для работы с цветами.
 * Поддерживает RGB, HSB, ARGB и преобразования между ними.
 */
public class ColorUtils {

    /**
     * Конвертирует RGB в ARGB с альфа-каналом.
     */
    public static int argb(float alpha, float red, float green, float blue) {
        int a = Math.round(alpha * 255);
        int r = Math.round(red * 255);
        int g = Math.round(green * 255);
        int b = Math.round(blue * 255);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    /**
     * Извлекает красный компонент из ARGB.
     */
    public static float getRed(int argb) {
        return ((argb >> 16) & 0xFF) / 255.0f;
    }

    /**
     * Извлекает зелёный компонент из ARGB.
     */
    public static float getGreen(int argb) {
        return ((argb >> 8) & 0xFF) / 255.0f;
    }

    /**
     * Извлекает синий компонент из ARGB.
     */
    public static float getBlue(int argb) {
        return (argb & 0xFF) / 255.0f;
    }

    /**
     * Извлекает альфа компонент из ARGB.
     */
    public static float getAlpha(int argb) {
        return ((argb >> 24) & 0xFF) / 255.0f;
    }

    /**
     * Преобразует HSB в RGB.
     */
    public static int hsbToRgb(float hue, float saturation, float brightness) {
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    /**
     * Преобразует RGB в HSB.
     */
    public static float[] rgbToHsb(float red, float green, float blue) {
        return Color.RGBtoHSB(
            Math.round(red * 255),
            Math.round(green * 255),
            Math.round(blue * 255),
            null
        );
    }

    /**
     * Интерполирует между двумя цветами.
     */
    public static int lerpColor(int color1, int color2, float t) {
        float r = lerp(getRed(color1), getRed(color2), t);
        float g = lerp(getGreen(color1), getGreen(color2), t);
        float b = lerp(getBlue(color1), getBlue(color2), t);
        float a = lerp(getAlpha(color1), getAlpha(color2), t);
        return argb(a, r, g, b);
    }

    /**
     * Линейная интерполяция между двумя значениями.
     */
    private static float lerp(float start, float end, float t) {
        return start + (end - start) * t;
    }

    /**
     * Возвращает цвет радуги на основе времени.
     */
    public static int getRainbowColor(long time, float saturation, float brightness) {
        float hue = (System.currentTimeMillis() % 3600) / 3600.0f;
        return hsbToRgb(hue, saturation, brightness);
    }

    /**
     * Преобразует цвет в строку формата #RRGGBB.
     */
    public static String colorToHex(int color) {
        return String.format("#%06X", (color & 0xFFFFFF));
    }

    /**
     * Преобразует строку формата #RRGGBB в цвет.
     */
    public static int hexToColor(String hex) {
        return (int) Long.parseLong(hex.replace("#", ""), 16);
    }

    /**
     * Применяет альфа к цвету.
     */
    public static int withAlpha(int color, float alpha) {
        return (Math.round(alpha * 255) << 24) | (color & 0xFFFFFF);
    }

    /**
     * Инвертирует цвет.
     */
    public static int invertColor(int color) {
        return (getAlpha(color) << 24) | ((0xFFFFFF) ^ (color & 0xFFFFFF));
    }
}
