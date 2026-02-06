package com.yourname.cinecraft.rendering;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Basic frame renderer
 */
public class FrameRenderer {

    private final int width, height;

    public FrameRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public BufferedImage renderFrame() {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        // TODO: render scene, camera, actors, particles
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        g.dispose();
        return img;
    }
}
