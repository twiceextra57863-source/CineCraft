package com.yourname.cinecraft.replay;

import com.yourname.cinecraft.camera.CameraSystem.CineCamera;
import com.yourname.cinecraft.animation.ActorEntity;

import java.util.List;

/**
 * Plays back a recorded replay
 */
public class ReplayPlayer {
    private final ReplayData replayData;
    private int currentFrame = 0;

    public ReplayPlayer(ReplayData data) {
        this.replayData = data;
    }

    public boolean hasNext() {
        return currentFrame < replayData.getTotalFrames();
    }

    public ReplayFrame nextFrame() {
        if (!hasNext()) return null;
        return replayData.getFrames().get(currentFrame++);
    }

    public void reset() {
        currentFrame = 0;
    }
}
