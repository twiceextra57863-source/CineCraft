package com.yourname.cinecraft.timeline;

/**
 * TimelinePlayer = controller layer
 */
public class TimelinePlayer {

    private final Timeline timeline;

    public TimelinePlayer(Timeline timeline) {
        this.timeline = timeline;
    }

    public void play() {
        timeline.play();
    }

    public void pause() {
        timeline.pause();
    }

    public void stop() {
        timeline.stop();
    }

    public void seek(int tick) {
        timeline.stop();
        while (timeline.getCurrentTick() < tick) {
            timeline.tick();
        }
    }

    public boolean isPlaying() {
        return timeline.isPlaying();
    }
}
