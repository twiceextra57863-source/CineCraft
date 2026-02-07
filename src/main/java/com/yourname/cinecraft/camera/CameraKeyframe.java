package com.yourname.cinecraft.camera;

/**
 * Stores camera state at a specific timeline tick
 */
public class CameraKeyframe {

    public int tick;
    public double x, y, z;
    public double pitch, yaw;
    public double fov;

    public CameraKeyframe(int tick, double x, double y, double z, double pitch, double yaw){
        this.tick = tick;
        this.x = x; this.y = y; this.z = z;
        this.pitch = pitch; this.yaw = yaw;
        this.fov = 70; // default
    }

    public CameraKeyframe(int tick, double x, double y, double z, double pitch, double yaw, double fov){
        this.tick = tick;
        this.x = x; this.y = y; this.z = z;
        this.pitch = pitch; this.yaw = yaw;
        this.fov = fov;
    }
}
