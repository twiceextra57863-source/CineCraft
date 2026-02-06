package com.yourname.cinecraft.camera.interpolation;

public class EaseInOut {

    public static double interpolate(double a, double b, double t) {
        t = t * t * (3 - 2 * t); // smoothstep
        return a + (b - a) * t;
    }

    public static float interpolate(float a, float b, float t) {
        t = t * t * (3 - 2 * t);
        return a + (b - a) * t;
    }
}
