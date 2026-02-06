package com.yourname.cinecraft;

import com.yourname.cinecraft.assetsys.AssetManager;
import com.yourname.cinecraft.camera.CameraSystem;
import com.yourname.cinecraft.timeline.TimelineSystem;
import com.yourname.cinecraft.export.ExportSystem;
import net.fabricmc.api.ModInitializer;

public class CineCraftMod implements ModInitializer {
    public static final String MOD_ID = "cinecraft";

    @Override
    public void onInitialize() {
        System.out.println("[CineCraft] Mod loaded successfully!");

        // Initialize all core systems
        AssetManager.init();
        CameraSystem.init();
        TimelineSystem.init();
        ExportSystem.init();
    }
}
