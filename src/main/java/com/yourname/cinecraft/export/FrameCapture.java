package com.yourname.cinecraft.export;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Captures rendered frames to disk
 */
public class FrameCapture {

    private final File outputDir;
    private int frameIndex = 0;

    public FrameCapture(File outputDir) {
        this.outputDir = outputDir;
        if (!outputDir.exists()) outputDir.mkdirs();
    }

    public void captureFrame(BufferedImage image) {
        String name = String.format("frame_%05d.png", frameIndex++);
        File out = new File(outputDir, name);
        try {
            ImageIO.write(image, "PNG", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getOutputDir() {
        return outputDir;
    }

    public int getFrameCount() {
        return frameIndex;
    }
}
