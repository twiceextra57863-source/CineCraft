package com.yourname.cinecraft.util;

public class MathUtil {

    public static double lerp(double a, double b, double t){ return a + (b-a)*t; }
    public static float lerp(float a, float b, float t){ return a + (b-a)*t; }
}
