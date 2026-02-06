package com.yourname.cinecraft.replay;

import com.yourname.cinecraft.camera.CameraSystem.CineCamera;
import com.yourname.cinecraft.animation.ActorEntity;

import java.util.List;

/**
 * Records timeline into ReplayData
 */
public class ReplayRecorder {
    private final ReplayData replayData = new ReplayData();
    private final CineCamera camera;
    private final List<ActorEntity> actors;

    public ReplayRecorder(CineCamera camera, List<ActorEntity> actors) {
        this.camera = camera;
        this.actors = actors;
    }

    public void recordFrame(int frameNumber) {
        ReplayFrame frame = new ReplayFrame(frameNumber, camera, actors);
        replayData.addFrame(frame);
    }

    public ReplayData getReplayData() {
        return replayData;
    }
}
