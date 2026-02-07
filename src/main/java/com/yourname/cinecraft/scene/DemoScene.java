package com.yourname.cinecraft.scene;

import com.yourname.cinecraft.CineCraftMod;
import com.yourname.cinecraft.animation.ActorEntity;
import com.yourname.cinecraft.timeline.Timeline;
import com.yourname.cinecraft.timeline.tracks.ActorTrack;
import com.yourname.cinecraft.timeline.tracks.CameraTrack;
import com.yourname.cinecraft.camera.CineCamera;
import com.yourname.cinecraft.camera.CameraKeyframe;
import com.yourname.cinecraft.rendering.ParticleSystem;
import com.yourname.cinecraft.replay.ReplayData;
import com.yourname.cinecraft.replay.ReplayRecorder;
import com.yourname.cinecraft.export.CineExportWorkflow;
import com.yourname.cinecraft.export.FrameCapture;
import com.yourname.cinecraft.rendering.FrameRenderer;

import java.awt.image.BufferedImage;

/**
 * Fully integrated demo scene
 */
public class DemoScene {

    private Timeline timeline;
    private ActorEntity hero;
    private CineCamera camera;
    private ParticleSystem particles;
    private ReplayRecorder recorder;

    public DemoScene(){
        // 1️⃣ Timeline
        timeline = new Timeline("Demo Scene Timeline");

        // 2️⃣ Actor
        hero = new ActorEntity("Hero");
        timeline.addActor(hero);
        ActorTrack actorTrack = new ActorTrack(hero);
        timeline.addTrack(actorTrack);

        // 3️⃣ Camera
        camera = CineCraftMod.camera;
        CameraTrack camTrack = new CameraTrack(camera);
        timeline.addTrack(camTrack);

        // Add keyframes
        camTrack.addKeyframe(new CameraKeyframe(0, 0, 5, 10, 0, 0));
        camTrack.addKeyframe(new CameraKeyframe(50, 10, 5, 12, 30, 0));
        camTrack.addKeyframe(new CameraKeyframe(100, 15, 5, 15, 60, 0));

        // 4️⃣ Particles
        particles = new ParticleSystem();

        // 5️⃣ Replay Recorder
        ReplayData replay = new ReplayData();
        recorder = new ReplayRecorder();
        recorder.startRecording(replay);
    }

    public void playScene(){
        System.out.println("[DemoScene] Playing demo scene...");

        // Simple loop for timeline frames
        for(int frame=0; frame<=100; frame++){
            timeline.update(frame); // updates actor + camera
            particles.update();

            // Spawn demo particle at frame 30
            if(frame == 30){
                particles.spawnParticle(new ParticleSystem.Particle(
                        hero.getX(), hero.getY()+1, hero.getZ(),
                        0, 0.1, 0,
                        50,
                        "spark"
                ));
            }

            // Render frame (BufferedImage)
            BufferedImage img = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
            FrameRenderer renderer = new FrameRenderer(1920,1080);
            BufferedImage rendered = renderer.renderFrame(); // TODO: draw actor + camera + particles

            // Capture frame to replay
            recorder.captureFrame(rendered);
        }

        // Stop recording
        recorder.stopRecording();

        // Export workflow
        FrameCapture capture = new FrameCapture("./minecraft/cinecraft/exports");
        CineExportWorkflow workflow = new CineExportWorkflow(capture, recorder.getReplayData(), new FrameRenderer(1920,1080), 30);
        workflow.export("./minecraft/cinecraft/exports/demo_scene.mp4");

        System.out.println("[DemoScene] Demo scene completed and exported!");
    }
}
