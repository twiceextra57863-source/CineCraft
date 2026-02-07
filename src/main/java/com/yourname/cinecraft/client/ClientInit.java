package com.yourname.cinecraft.client;

import com.yourname.cinecraft.CineCraftMod;
import com.yourname.cinecraft.assetsys.AssetManager;
import com.yourname.cinecraft.camera.CameraController;
import com.yourname.cinecraft.client.input.ClientKeybinds;
import com.yourname.cinecraft.client.renderer.CineWorldRenderer;
import com.yourname.cinecraft.ui.TimelineScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;

/**
 * Client-side initializer for CineCraft
 * 
 * Responsible for:
 * - Camera system init
 * - Keybinds
 * - Renderer hooks
 * - Asset preloading
 * - Client tick updates
 */
public class ClientInit implements ClientModInitializer {

    private static MinecraftClient client;

    @Override
    public void onInitializeClient() {
        client = MinecraftClient.getInstance();

        CineCraftMod.LOGGER.info("[CineCraft] ClientInit starting...");

        // -------------------------
        // 1. Register Keybinds
        // -------------------------
        ClientKeybinds.register();

        // -------------------------
        // 2. Init Camera Controller
        // -------------------------
        CameraController.init();

        // -------------------------
        // 3. Register World Renderer
        // -------------------------
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            CineWorldRenderer.render(context);
        });

        // -------------------------
        // 4. Client Tick Logic
        // -------------------------
        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            if (mc.player == null) return;

            CameraController.tick();
            ClientKeybinds.handleInput(mc);
        });

        // -------------------------
        // 5. Preload Assets (optional but recommended)
        // -------------------------
        preloadAssets();

        CineCraftMod.LOGGER.info("[CineCraft] ClientInit finished");
    }

    /**
     * Preload common assets to avoid lag during playback
     */
    private void preloadAssets() {
        try {
            // Animations
            AssetManager.loadAnimation("Walk.anim");
            AssetManager.loadAnimation("Run.anim");
            AssetManager.loadAnimation("Punch.anim");

            // Particles
            AssetManager.loadParticle("smoke.particle");
            AssetManager.loadParticle("spark.particle");

            // Models
            AssetManager.loadModel("actor.bbmodel");
            AssetManager.loadModel("camera.obj");

            // Textures
            AssetManager.loadTexture("actor.png");
            AssetManager.loadTexture("effects.png");

            CineCraftMod.LOGGER.info("[CineCraft] Assets preloaded");

        } catch (Exception e) {
            CineCraftMod.LOGGER.error("[CineCraft] Asset preload failed", e);
        }
    }

    // =========================
    // Utility
    // =========================
    public static MinecraftClient getClient() {
        return client;
    }

    /**
     * Opens the CineCraft Timeline Editor UI
     */
    public static void openTimelineEditor() {
        if (client == null) return;
        client.setScreen(new TimelineScreen());
    }
}
