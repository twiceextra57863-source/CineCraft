package com.yourname.cinecraft.export;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Integrates Replay -> Rendering -> FFmpeg export
 */
public class CineExportWorkflow {

    private final FrameCapture capture;
    private final ReplayData replay;
    private final FrameRenderer renderer;
    private final int fps;

    public CineExportWorkflow(FrameCapture capture, ReplayData replay, FrameRenderer renderer, int fps){
        this.capture=capture; this.replay=replay; this.renderer=renderer; this.fps=fps;
    }

    public void export(String outputPath){
        System.out.println("[Workflow] Starting export...");
        for(int i=0;i<replay.getTotalFrames();i++){
            // render frame from replay
            BufferedImage img = renderer.renderFrame();
            capture.captureFrame(img);
        }
        FFmpegBridge.exportVideo(capture.toString()+"/frame_%04d.png", outputPath, fps);
        System.out.println("[Workflow] Export finished: "+outputPath);
    }
}
