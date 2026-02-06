package com.yourname.cinecraft.export;

/**
 * Handles audio export
 * TODO: Implement actual audio rendering/merging with video
 */
public class AudioExporter {

    public static void exportAudio(String audioFile, String videoFile, String outputFile) {
        String cmd = "ffmpeg -y -i " + videoFile + " -i " + audioFile + " -c:v copy -c:a aac " + outputFile;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            System.out.println("[CineCraft] Audio merged to video: " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
