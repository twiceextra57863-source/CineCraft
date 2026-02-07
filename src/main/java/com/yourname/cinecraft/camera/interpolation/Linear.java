package com.yourname.cinecraft.camera.interpolation;

public class Linear implements Interpolation {
    @Override
    public double interpolate(double start, double end, double alpha) {
        return start + (end - start) * alpha;
    }
}
