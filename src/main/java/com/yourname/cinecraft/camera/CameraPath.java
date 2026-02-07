package com.yourname.cinecraft.camera;

import com.yourname.cinecraft.camera.interpolation.Linear;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores a sequence of CameraKeyframes and interpolation type
 */
public class CameraPath {

    private List<CameraKeyframe> keyframes;
    private com.yourname.cinecraft.camera.interpolation.Interpolation interpolation;

    public CameraPath(){
        this.keyframes = new ArrayList<>();
        this.interpolation = new Linear(); // default interpolation
    }

    public void addKeyframe(CameraKeyframe keyframe){
        keyframes.add(keyframe);
    }

    public List<CameraKeyframe> getKeyframes(){ return keyframes; }

    public void setInterpolation(com.yourname.cinecraft.camera.interpolation.Interpolation interp){
        this.interpolation = interp;
    }

    public com.yourname.cinecraft.camera.interpolation.Interpolation getInterpolation(){
        return interpolation;
    }
}
