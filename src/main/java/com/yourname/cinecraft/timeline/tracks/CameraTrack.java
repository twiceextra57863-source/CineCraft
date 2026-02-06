package com.yourname.cinecraft.timeline.tracks;

import com.yourname.cinecraft.camera.CameraSystem.CineCamera;
import com.yourname.cinecraft.camera.CameraSystem.CameraKeyframe;
import com.yourname.cinecraft.timeline.Track;
import java.util.List;

public class CameraTrack extends Track {

    private final CineCamera camera;

    public CameraTrack(String name, CineCamera camera) {
        super(name);
        this.camera = camera;
        this.length = camera.getKeyframes().isEmpty() ? 0 :
                camera.getKeyframes().get(camera.getKeyframes().size() - 1).frame;
    }

    @Override
    public void applyFrame(int frame) {
        camera.applyFrame(frame);
    }
}
