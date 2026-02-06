package com.yourname.cinecraft.animation;

public class Keyframe {
    public final int frame;
    public final float[] rotation; // pitch,yaw,roll
    public final double[] position; // x,y,z

    public Keyframe(int frame, double x, double y, double z, float pitch, float yaw, float roll){
        this.frame = frame;
        this.position = new double[]{x,y,z};
        this.rotation = new float[]{pitch,yaw,roll};
    }
}
