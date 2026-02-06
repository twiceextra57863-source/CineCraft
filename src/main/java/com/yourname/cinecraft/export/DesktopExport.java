package com.yourname.cinecraft.export;

/**
 * Desktop export helper
 */
public class DesktopExport {

    public static void export(String framesDir, String outputFile, int fps) {
        FFmpegBridge.exportVideo(framesDir + "/frame_%04d.png", outputFile, fps);
    }
}
