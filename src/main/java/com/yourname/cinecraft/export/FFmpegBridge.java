package com.yourname.cinecraft.export;

import java.io.IOException;

/**
 * Bridges Minecraft frames to video using FFmpeg
 */
public class FFmpegBridge {

    /**
     * Exports images to video using ffmpeg command
     * @param inputPattern e.g., frame_%04d.png
     * @param outputFile e.g., movie.mp4
     * @param fps frames per second
     */
    public static void exportVideo(String inputPattern, String outputFile, int fps) {
        String cmd = "ffmpeg -y -framerate " + fps + " -i " + inputPattern
                + " -c:v libx264 -pix_fmt yuv420p " + outputFile;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            System.out.println("[CineCraft] Export completed: " + outputFile);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
