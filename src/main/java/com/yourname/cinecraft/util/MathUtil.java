package com.yourname.cinecraft.util;

public class MathUtil {

    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static float clamp(float v, float min, float max) {
        return Math.max(min, Math.min(max, v));
    }

    public static double clamp(double v, double min, double max) {
        return Math.max(min, Math.min(max, v));
    }

    public static float normalizeAngle(float angle) {
        angle %= 360f;
        if (angle < 0) angle += 360f;
        return angle;
    }

    public static double map(
            double value,
            double inMin, double inMax,
            double outMin, double outMax
    ) {
        double t = (value - inMin) / (inMax - inMin);
        return outMin + (outMax - outMin) * t;
    }
}
