package com.yourname.cinecraft.timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Track = clips ka container
 */
public abstract class Track {

    protected final String name;
    protected final List<Clip> clips = new ArrayList<>();

    public Track(String name) {
        this.name = name;
    }

    public void addClip(Clip clip) {
        clips.add(clip);
    }

    public void removeClip(Clip clip) {
        clips.remove(clip);
    }

    public void tick(int currentTick) {
        for (Clip clip : clips) {
            if (clip.isActive(currentTick)) {
                int localTick = currentTick - clip.getStartTick();
                clip.onTick(localTick);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Clip> getClips() {
        return clips;
    }
}
