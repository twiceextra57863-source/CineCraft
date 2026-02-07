package com.yourname.cinecraft.common;

import com.yourname.cinecraft.CineCraftMod;
import com.yourname.cinecraft.replay.ReplayRecorder;
import com.yourname.cinecraft.replay.ReplayPlayer;
import com.yourname.cinecraft.timeline.Timeline;
import com.yourname.cinecraft.util.PlatformUtil;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

/**
 * ModRegistry
 *
 * Central registry for CineCraft (COMMON side)
 * - Server lifecycle hooks
 * - Replay tick handling
 * - Timeline sync
 */
public class ModRegistry {

    private static MinecraftServer server;

    /**
     * Called from CineCraftMod.onInitialize()
     */
    public static void init() {
        CineCraftMod.LOGGER.info("[CineCraft] ModRegistry initializing...");

        registerServerLifecycle();
        registerServerTick();

        CineCraftMod.LOGGER.info("[CineCraft] ModRegistry initialized");
    }

    // =========================
    // Server Lifecycle
    // =========================
    private static void registerServerLifecycle() {

        ServerLifecycleEvents.SERVER_STARTED.register(srv -> {
            server = srv;
            CineCraftMod.LOGGER.info("[CineCraft] Server started");
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(srv -> {
            CineCraftMod.LOGGER.info("[CineCraft] Server stopping");
            ReplayRecorder.stopAll();
            ReplayPlayer.stopAll();
        });
    }

    // =========================
    // Server Tick
    // =========================
    private static void registerServerTick() {

        ServerTickEvents.END_SERVER_TICK.register(srv -> {
            Timeline.tick();
            ReplayRecorder.tick();
            ReplayPlayer.tick();
        });
    }

    // =========================
    // Utility
    // =========================
    public static MinecraftServer getServer() {
        return server;
    }

    public static boolean isDedicatedServer() {
        return PlatformUtil.isDedicatedServer();
    }
}
