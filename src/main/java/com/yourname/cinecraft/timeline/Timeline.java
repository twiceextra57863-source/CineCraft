package com.yourname.cinecraft.timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Timeline = complete cinematic sequence
 */
public class Timeline {

    private static Timeline active;

    private final List<Track> tracks = new ArrayList<>();
    private final List<Marker> markers = new ArrayList<>();

    private int currentTick = 0;
    private boolean playing = false;

    public static Timeline getActive() {
        if (active == null) active = new Timeline();
        return active;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void addMarker(Marker marker) {
        markers.add(marker);
    }

    public void play() {
        playing = true;
    }

    public void pause() {
        playing = false;
    }

    public void stop() {
        playing = false;
        currentTick = 0;
    }

    public void tick() {
        if (!playing) return;

        for (Track track : tracks) {
            track.tick(currentTick);
        }

        currentTick++;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public boolean isPlaying() {
        return playing;
    }
}
