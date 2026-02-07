package com.yourname.cinecraft.timeline;

/**
 * Marker = timeline reference point
 * Example: "Beat Drop", "Camera Cut"
 */
public class Marker {

    private final String name;
    private final int tick;

    public Marker(String name, int tick) {
        this.name = name;
        this.tick = tick;
    }

    public String getName() {
        return name;
    }

    public int getTick() {
        return tick;
    }
}
