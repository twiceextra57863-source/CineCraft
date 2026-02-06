package com.yourname.cinecraft.ui;

import com.yourname.cinecraft.export.DesktopExport;
import com.yourname.cinecraft.export.FrameCapture;
import java.awt.image.BufferedImage;

/**
 * Export UI Screen
 */
public class ExportScreen {

    private final FrameCapture capture;

    public ExportScreen(FrameCapture capture) { this.capture = capture; }

    public void exportVideo(String outputPath, int fps){
        DesktopExport.export(capture.toString(), outputPath, fps);
        System.out.println("[UI] Export initiated to: "+outputPath);
    }

    public void captureFrame(BufferedImage img){
        capture.captureFrame(img);
    }
}
