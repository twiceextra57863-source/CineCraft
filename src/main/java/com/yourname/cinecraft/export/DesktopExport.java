package com.yourname.cinecraft.export;

import java.io.File;

/**
 * Desktop video exporter
 */
public class DesktopExport {

    private final File framesDir;
    private final File audioFile;
    private final File outputFile;
    private final int fps;

    public DesktopExport(File framesDir, File audioFile, File outputFile, int fps) {
        this.framesDir = framesDir;
        this.audioFile = audioFile;
        this.outputFile = outputFile;
        this.fps = fps;
    }

    public void export() {
        String ffmpeg = "ffmpeg"; // system PATH
        String pattern = new File(framesDir, "frame_%05d.png").getAbsolutePath();

        FFmpegBridge.exportVideo(
                ffmpeg,
                pattern,
                audioFile != null ? audioFile.getAbsolutePath() : null,
                outputFile.getAbsolutePath(),
                fps
        );
    }
}
