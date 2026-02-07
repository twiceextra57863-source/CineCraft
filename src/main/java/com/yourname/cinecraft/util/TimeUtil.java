package com.yourname.cinecraft.util;

public class TimeUtil {

    public static long nowMs() {
        return System.currentTimeMillis();
    }

    public static double secondsToFrames(double seconds, int fps) {
        return seconds * fps;
    }

    public static double framesToSeconds(double frames, int fps) {
        return frames / fps;
    }

    public static double tickDelta(double lastTimeMs) {
        long now = nowMs();
        return (now - lastTimeMs) / 1000.0;
    }
}
