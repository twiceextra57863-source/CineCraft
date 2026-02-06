package com.yourname.cinecraft.camera.interpolation;

public class Linear {

    public static double interpolate(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static float interpolate(float a, float b, float t) {
        return a + (b - a) * t;
    }
}
