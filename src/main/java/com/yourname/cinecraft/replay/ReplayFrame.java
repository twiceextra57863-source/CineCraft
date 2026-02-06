package com.yourname.cinecraft.replay;

import com.yourname.cinecraft.camera.CameraSystem.CineCamera;
import com.yourname.cinecraft.animation.ActorEntity;

import java.util.List;

/**
 * Stores one frame of a replay
 */
public class ReplayFrame {
    public int frameNumber;
    public double cameraX, cameraY, cameraZ;
    public float cameraPitch, cameraYaw;
    public List<ActorEntity> actors;

    public ReplayFrame(int frameNumber, CineCamera camera, List<ActorEntity> actors) {
        this.frameNumber = frameNumber;
        this.cameraX = camera != null ? camera.getKeyframes().get(0).x : 0;
        this.cameraY = camera != null ? camera.getKeyframes().get(0).y : 0;
        this.cameraZ = camera != null ? camera.getKeyframes().get(0).z : 0;
        this.cameraPitch = camera != null ? camera.getKeyframes().get(0).pitch : 0;
        this.cameraYaw = camera != null ? camera.getKeyframes().get(0).yaw : 0;
        this.actors = actors;
    }
}
