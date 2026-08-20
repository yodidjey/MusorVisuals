package com.musor.visuals.render;

import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL20;

/**
 * Управление кастомными шейдерами для продвинутых визуальных эффектов.
 * Поддерживает компиляцию, кеширование и применение шейдеров.
 */
public class ShaderManager {
    private static class ShaderProgram {
        public int programId;
        public int vertexShader;
        public int fragmentShader;

        public ShaderProgram(int programId, int vertexShader, int fragmentShader) {
            this.programId = programId;
            this.vertexShader = vertexShader;
            this.fragmentShader = fragmentShader;
        }
    }

    private java.util.Map<String, ShaderProgram> shaderCache = new java.util.HashMap<>();

    /**
     * Загружает и компилирует шейдер.
     */
    public void loadShader(String name, String vertexSource, String fragmentSource) {
        try {
            int vertexShader = compileShader(vertexSource, GL20.GL_VERTEX_SHADER);
            int fragmentShader = compileShader(fragmentSource, GL20.GL_FRAGMENT_SHADER);
            int programId = linkProgram(vertexShader, fragmentShader);

            shaderCache.put(name, new ShaderProgram(programId, vertexShader, fragmentShader));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load shader: " + name, e);
        }
    }

    /**
     * Компилирует отдельный шейдер.
     */
    private int compileShader(String source, int type) {
        int shader = GL20.glCreateShader(type);
        GL20.glShaderSource(shader, source);
        GL20.glCompileShader(shader);

        int compiled = GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS);
        if (compiled == 0) {
            String log = GL20.glGetShaderInfoLog(shader);
            throw new RuntimeException("Shader compilation failed:\n" + log);
        }

        return shader;
    }

    /**
     * Связывает шейдеры в программу.
     */
    private int linkProgram(int vertexShader, int fragmentShader) {
        int program = GL20.glCreateProgram();
        GL20.glAttachShader(program, vertexShader);
        GL20.glAttachShader(program, fragmentShader);
        GL20.glLinkProgram(program);

        int linked = GL20.glGetProgrami(program, GL20.GL_LINK_STATUS);
        if (linked == 0) {
            String log = GL20.glGetProgramInfoLog(program);
            throw new RuntimeException("Program linking failed:\n" + log);
        }

        return program;
    }

    /**
     * Применяет шейдер.
     */
    public void useShader(String name) {
        ShaderProgram program = shaderCache.get(name);
        if (program != null) {
            GL20.glUseProgram(program.programId);
        }
    }

    /**
     * Отключает текущий шейдер.
     */
    public void useNoShader() {
        GL20.glUseProgram(0);
    }

    /**
     * Устанавливает uniform переменную (float).
     */
    public void setUniform(String shaderName, String uniformName, float value) {
        ShaderProgram program = shaderCache.get(shaderName);
        if (program != null) {
            int location = GL20.glGetUniformLocation(program.programId, uniformName);
            GL20.glUniform1f(location, value);
        }
    }

    /**
     * Устанавливает uniform переменную (vec4).
     */
    public void setUniform(String shaderName, String uniformName, float x, float y, float z, float w) {
        ShaderProgram program = shaderCache.get(shaderName);
        if (program != null) {
            int location = GL20.glGetUniformLocation(program.programId, uniformName);
            GL20.glUniform4f(location, x, y, z, w);
        }
    }

    /**
     * Очищает кеш шейдеров при выходе.
     */
    public void cleanup() {
        for (ShaderProgram program : shaderCache.values()) {
            GL20.glDeleteShader(program.vertexShader);
            GL20.glDeleteShader(program.fragmentShader);
            GL20.glDeleteProgram(program.programId);
        }
        shaderCache.clear();
    }
}
