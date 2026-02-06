package com.yourname.cinecraft.replay;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores all frames of a replay
 */
public class ReplayData {
    private final List<ReplayFrame> frames = new ArrayList<>();

    public void addFrame(ReplayFrame frame) {
        frames.add(frame);
    }

    public List<ReplayFrame> getFrames() {
        return frames;
    }

    public int getTotalFrames() {
        return frames.size();
    }
}
