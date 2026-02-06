package com.yourname.cinecraft.timeline;

public abstract class Track {
    protected String name;
    protected int length = 0; // frames

    public Track(String name) { this.name = name; }

    public abstract void applyFrame(int frame);

    public String getName() { return name; }
    public int getLength() { return length; }
}
