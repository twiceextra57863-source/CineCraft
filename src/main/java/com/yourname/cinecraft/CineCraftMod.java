package com.yourname.cinecraft;

import com.yourname.cinecraft.assetsys.AssetManager;
import com.yourname.cinecraft.assetsys.ModelLoader;
import com.yourname.cinecraft.camera.CineCamera;
import com.yourname.cinecraft.camera.CameraPath;
import com.yourname.cinecraft.animation.ActorEntity;
import com.yourname.cinecraft.timeline.Timeline;
import com.yourname.cinecraft.timeline.tracks.CameraTrack;
import com.yourname.cinecraft.replay.ReplayData;
import com.yourname.cinecraft.replay.ReplayRecorder;
import com.yourname.cinecraft.replay.storage.ReplayStorage;
import com.yourname.cinecraft.editor.ModelEditor;
import com.yourname.cinecraft.editor.Gizmo;
import com.yourname.cinecraft.editor.tools.MoveTool;
import com.yourname.cinecraft.editor.tools.RotateTool;
import com.yourname.cinecraft.editor.tools.ScaleTool;
import com.yourname.cinecraft.export.CineExportWorkflow;
import com.yourname.cinecraft.export.FrameCapture;
import com.yourname.cinecraft.rendering.FrameRenderer;

import net.fabricmc.api.ModInitializer;

public class CineCraftMod implements ModInitializer {

    public static final String MOD_ID = "cinecraft";

    // Core Systems
    public static AssetManager assetManager;
    public static CineCamera camera;
    public static Timeline timeline;
    public static ReplayRecorder replayRecorder;
    public static ModelEditor editor;

    @Override
    public void onInitialize() {
        System.out.println("[CineCraft] Initializing mod...");

        // 1️⃣ Load Assets
        assetManager = new AssetManager();
        AssetManager.init();
        ModelLoader.loadAll();

        // 2️⃣ Initialize Camera
        camera = new CineCamera();
        CameraPath camPath = new CameraPath();
        camera.setPath(camPath);
        System.out.println("[CineCraft] Camera initialized");

        // 3️⃣ Initialize Timeline
        timeline = new Timeline("Main Timeline");
        CameraTrack camTrack = new CameraTrack(camera);
        timeline.addTrack(camTrack);
        System.out.println("[CineCraft] Timeline initialized");

        // 4️⃣ Initialize Replay
        replayRecorder = new ReplayRecorder();
        ReplayData demoReplay = ReplayStorage.loadReplay("demo");
        if(demoReplay==null) demoReplay = new ReplayData();
        replayRecorder.startRecording(demoReplay);

        // 5️⃣ Initialize Editor
        editor = new ModelEditor();
        Gizmo gizmo = new Gizmo();
        MoveTool moveTool = new MoveTool(gizmo);
        RotateTool rotateTool = new RotateTool(gizmo);
        ScaleTool scaleTool = new ScaleTool(gizmo);

        System.out.println("[CineCraft] Editor initialized");

        // 6️⃣ Example: Add actor and play timeline
        ActorEntity actor = new ActorEntity("Hero");
        timeline.addActor(actor);
        timeline.play();

        // 7️⃣ Export example workflow
        FrameCapture capture = new FrameCapture("./minecraft/cinecraft/exports");
        FrameRenderer renderer = new FrameRenderer(1920, 1080);
        int fps = 30;
        CineExportWorkflow workflow = new CineExportWorkflow(capture, demoReplay, renderer, fps);

        System.out.println("[CineCraft] Initialization complete. Mod is ready!");

        // Optional: auto-export demo after initialization
        // workflow.export("./minecraft/cinecraft/exports/demo.mp4");
    }
}
