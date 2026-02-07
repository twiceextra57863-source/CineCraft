package com.yourname.cinecraft.timeline;

/**
 * Clip = timeline ka ek block
 * Example: Walk animation from 0s–3s
 */
public class Clip {

    private final String id;
    private int startTick;
    private int endTick;
    private boolean enabled = true;

    public Clip(String id, int startTick, int endTick) {
        this.id = id;
        this.startTick = startTick;
        this.endTick = endTick;
    }

    public boolean isActive(int currentTick) {
        return enabled && currentTick >= startTick && currentTick <= endTick;
    }

    public void onStart() {}
    public void onTick(int localTick) {}
    public void onEnd() {}

    public int getDuration() {
        return endTick - startTick;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getEndTick() {
        return endTick;
    }

    public String getId() {
        return id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
