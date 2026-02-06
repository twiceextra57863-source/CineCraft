package com.yourname.cinecraft.camera.interpolation;

public class Cubic {

    public static double interpolate(double a, double b, double t) {
        t = t*t*t; // cubic easing
        return a + (b - a) * t;
    }

    public static float interpolate(float a, float b, float t) {
        t = t*t*t;
        return a + (b - a) * t;
    }
}
