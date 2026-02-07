package com.yourname.cinecraft.camera;

import com.yourname.cinecraft.camera.interpolation.Interpolation;

import java.util.ArrayList;
import java.util.List;

/**
 * CineCraft Camera for cinematic shots
 */
public class CineCamera {

    private double x, y, z;
    private double pitch, yaw;
    private double fov = 70; // default FOV
    private CameraPath path;

    public CineCamera(){
        this.x = 0; this.y = 5; this.z = 0;
        this.pitch = 0; this.yaw = 0;
        this.path = new CameraPath();
    }

    public void setPath(CameraPath path){
        this.path = path;
    }

    public CameraPath getPath(){ return path; }

    public void update(int tick){
        if(path == null || path.getKeyframes().isEmpty()) return;

        // Find the surrounding keyframes
        CameraKeyframe prev = path.getKeyframes().get(0);
        CameraKeyframe next = path.getKeyframes().get(path.getKeyframes().size()-1);

        for(int i=0;i<path.getKeyframes().size()-1;i++){
            if(path.getKeyframes().get(i).tick <= tick &&
               path.getKeyframes().get(i+1).tick >= tick){
                prev = path.getKeyframes().get(i);
                next = path.getKeyframes().get(i+1);
                break;
            }
        }

        double alpha = (double)(tick - prev.tick)/(next.tick - prev.tick);

        // Interpolate position using specified method
        Interpolation interp = path.getInterpolation();
        this.x = interp.interpolate(prev.x, next.x, alpha);
        this.y = interp.interpolate(prev.y, next.y, alpha);
        this.z = interp.interpolate(prev.z, next.z, alpha);

        // Interpolate rotation
        this.yaw = interp.interpolate(prev.yaw, next.yaw, alpha);
        this.pitch = interp.interpolate(prev.pitch, next.pitch, alpha);

        // Interpolate FOV
        this.fov = interp.interpolate(prev.fov, next.fov, alpha);
    }

    // Getters
    public double getX(){ return x; }
    public double getY(){ return y; }
    public double getZ(){ return z; }
    public double getYaw(){ return yaw; }
    public double getPitch(){ return pitch; }
    public double getFov(){ return fov; }
}
