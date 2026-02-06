package com.yourname.cinecraft.export;

/**
 * Android export helper (requires Termux or FFmpeg installed)
 */
public class AndroidExport {

    public static void export(String framesDir, String outputFile, int fps) {
        FFmpegBridge.exportVideo(framesDir + "/frame_%04d.png", outputFile, fps);
    }
}
