package com.yourname.cinecraft.camera.interpolation;

public class EaseInOut implements Interpolation {
    @Override
    public double interpolate(double start, double end, double alpha) {
        double t = alpha*alpha*(3 - 2*alpha);
        return start + (end - start) * t;
    }
}
