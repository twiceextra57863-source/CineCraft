package com.yourname.cinecraft.export;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Bridge between CineCraft and FFmpeg
 */
public class FFmpegBridge {

    public static void exportVideo(
            String ffmpegPath,
            String framePattern,
            String audioPath,
            String outputPath,
            int fps
    ) {
        try {
            ProcessBuilder pb;

            if (audioPath != null) {
                pb = new ProcessBuilder(
                        ffmpegPath,
                        "-y",
                        "-framerate", String.valueOf(fps),
                        "-i", framePattern,
                        "-i", audioPath,
                        "-c:v", "libx264",
                        "-pix_fmt", "yuv420p",
                        "-c:a", "aac",
                        outputPath
                );
            } else {
                pb = new ProcessBuilder(
                        ffmpegPath,
                        "-y",
                        "-framerate", String.valueOf(fps),
                        "-i", framePattern,
                        "-c:v", "libx264",
                        "-pix_fmt", "yuv420p",
                        outputPath
                );
            }

            pb.redirectErrorStream(true);
            Process process = pb.start();

            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                while (reader.readLine() != null) {}
            }

            process.waitFor();
            System.out.println("[FFmpeg] Export finished: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
