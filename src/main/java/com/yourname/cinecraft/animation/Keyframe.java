package com.yourname.cinecraft.animation;

/**
 * Stores actor position/rotation at a tick
 */
public class Keyframe {

    public int tick;
    public double x, y, z;
    public double yaw, pitch;

    public Keyframe(int tick, double x, double y, double z, double yaw, double pitch){
        this.tick = tick;
        this.x = x; this.y = y; this.z = z;
        this.yaw = yaw; this.pitch = pitch;
    }
}
