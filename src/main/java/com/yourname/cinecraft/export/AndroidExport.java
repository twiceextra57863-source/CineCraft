package com.yourname.cinecraft.export;

import java.io.File;

/**
 * Android / PojavLauncher export
 */
public class AndroidExport {

    private final File framesDir;
    private final File outputFile;
    private final int fps;

    public AndroidExport(File framesDir, File outputFile, int fps) {
        this.framesDir = framesDir;
        this.outputFile = outputFile;
        this.fps = fps;
    }

    public void export(String ffmpegBinaryPath) {
        String pattern = new File(framesDir, "frame_%05d.png").getAbsolutePath();

        FFmpegBridge.exportVideo(
                ffmpegBinaryPath,
                pattern,
                null,
                outputFile.getAbsolutePath(),
                fps
        );
    }
}
