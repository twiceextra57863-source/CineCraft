package com.yourname.cinecraft.camera.interpolation;

public class Cubic implements Interpolation {
    @Override
    public double interpolate(double start, double end, double alpha) {
        double t = alpha*alpha*alpha;
        return start + (end - start) * t;
    }
}
