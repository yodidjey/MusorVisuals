package com.musor.visuals.util.animation;

/**
 * Система интерполяции для плавных анимаций.
 * Поддерживает различные easing функции.
 */
public class AnimationUtils {

    /**
     * Linear интерполяция (без ускорения/замедления).
     */
    public static float linear(float t) {
        return t;
    }

    /**
     * Ease In Quad - медленный старт.
     */
    public static float easeInQuad(float t) {
        return t * t;
    }

    /**
     * Ease Out Quad - медленный финиш.
     */
    public static float easeOutQuad(float t) {
        return 1.0f - (1.0f - t) * (1.0f - t);
    }

    /**
     * Ease In Out Quad - медленно в начале и конце.
     */
    public static float easeInOutQuad(float t) {
        return t < 0.5f ? 2.0f * t * t : 1.0f - (float)Math.pow(-2.0f * t + 2.0f, 2.0f) / 2.0f;
    }

    /**
     * Ease In Cubic.
     */
    public static float easeInCubic(float t) {
        return t * t * t;
    }

    /**
     * Ease Out Cubic.
     */
    public static float easeOutCubic(float t) {
        return 1.0f - (float)Math.pow(1.0f - t, 3.0f);
    }

    /**
     * Ease In Out Cubic.
     */
    public static float easeInOutCubic(float t) {
        return t < 0.5f ? 4.0f * t * t * t : 1.0f - (float)Math.pow(-2.0f * t + 2.0f, 3.0f) / 2.0f;
    }

    /**
     * Ease In Sine.
     */
    public static float easeInSine(float t) {
        return 1.0f - (float)Math.cos((t * Math.PI) / 2.0f);
    }

    /**
     * Ease Out Sine.
     */
    public static float easeOutSine(float t) {
        return (float)Math.sin((t * Math.PI) / 2.0f);
    }

    /**
     * Ease In Out Sine.
     */
    public static float easeInOutSine(float t) {
        return -(float)(Math.cos(Math.PI * t) - 1.0f) / 2.0f;
    }

    /**
     * Интерполяция между двумя значениями с заданной easing функцией.
     * @param start Начальное значение
     * @param end Конечное значение
     * @param t Прогресс (0.0f - 1.0f)
     * @param easing Тип интерполяции
     * @return Интерполированное значение
     */
    public static float interpolate(float start, float end, float t, EasingType easing) {
        float easedT = switch(easing) {
            case LINEAR -> linear(t);
            case EASE_IN_QUAD -> easeInQuad(t);
            case EASE_OUT_QUAD -> easeOutQuad(t);
            case EASE_IN_OUT_QUAD -> easeInOutQuad(t);
            case EASE_IN_CUBIC -> easeInCubic(t);
            case EASE_OUT_CUBIC -> easeOutCubic(t);
            case EASE_IN_OUT_CUBIC -> easeInOutCubic(t);
            case EASE_IN_SINE -> easeInSine(t);
            case EASE_OUT_SINE -> easeOutSine(t);
            case EASE_IN_OUT_SINE -> easeInOutSine(t);
        };
        return start + (end - start) * easedT;
    }

    public enum EasingType {
        LINEAR,
        EASE_IN_QUAD,
        EASE_OUT_QUAD,
        EASE_IN_OUT_QUAD,
        EASE_IN_CUBIC,
        EASE_OUT_CUBIC,
        EASE_IN_OUT_CUBIC,
        EASE_IN_SINE,
        EASE_OUT_SINE,
        EASE_IN_OUT_SINE
    }

    /**
     * Класс для управления анимациями с состоянием.
     */
    public static class Animation {
        private float startValue;
        private float endValue;
        private float currentValue;
        private long startTime;
        private long duration;
        private EasingType easing;
        private boolean finished;

        public Animation(float start, float end, long duration, EasingType easing) {
            this.startValue = start;
            this.endValue = end;
            this.currentValue = start;
            this.duration = duration;
            this.easing = easing;
            this.startTime = System.currentTimeMillis();
            this.finished = false;
        }

        public void update() {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed >= duration) {
                currentValue = endValue;
                finished = true;
            } else {
                float t = (float) elapsed / duration;
                currentValue = interpolate(startValue, endValue, t, easing);
            }
        }

        public float getValue() {
            update();
            return currentValue;
        }

        public boolean isFinished() {
            return finished;
        }

        public void reset() {
            startTime = System.currentTimeMillis();
            finished = false;
        }
    }
}
