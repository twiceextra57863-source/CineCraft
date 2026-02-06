package com.yourname.cinecraft.timeline;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

    private final String name;
    private final List<Track> tracks = new ArrayList<>();
    private int totalFrames = 0;

    public Timeline(String name) { this.name = name; }

    public void addTrack(Track track) {
        tracks.add(track);
        totalFrames = Math.max(totalFrames, track.getLength());
    }

    public List<Track> getTracks() { return tracks; }
    public String getName() { return name; }
    public int getTotalFrames() { return totalFrames; }
}
