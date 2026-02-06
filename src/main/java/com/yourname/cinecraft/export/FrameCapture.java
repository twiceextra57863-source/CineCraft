package com.yourname.cinecraft.export;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Captures frames from mod render for export
 */
public class FrameCapture {

    private int frameCount = 0;
    private final String outputDir;

    public FrameCapture(String outputDir) {
        this.outputDir = outputDir;
        new File(outputDir).mkdirs();
    }

    public void captureFrame(BufferedImage img) {
        try {
            String filename = String.format("%s/frame_%04d.png", outputDir, frameCount++);
            ImageIO.write(img, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() { frameCount = 0; }
}
