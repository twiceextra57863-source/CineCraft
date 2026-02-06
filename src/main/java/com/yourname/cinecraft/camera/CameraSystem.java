package com.yourname.cinecraft.camera;

import java.util.ArrayList;
import java.util.List;

/**
 * CineCraft Camera System
 * Handles cameras, keyframes, paths, and interpolation
 */
public class CameraSystem {

    private static final List<CineCamera> cameras = new ArrayList<>();

    public static void init() {
        System.out.println("[CineCraft] Camera System Initialized!");
    }

    /** Create a new camera */
    public static CineCamera createCamera(String name) {
        CineCamera cam = new CineCamera(name);
        cameras.add(cam);
        return cam;
    }

    /** Get all cameras */
    public static List<CineCamera> getCameras() {
        return cameras;
    }

    // ------------------- CineCamera Class -------------------
    public static class CineCamera {
        private final String name;
        private double x, y, z;
        private float pitch, yaw;
        private final List<CameraKeyframe> keyframes = new ArrayList<>();

        public CineCamera(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public void setPosition(double x, double y, double z) {
            this.x = x; this.y = y; this.z = z;
        }

        public void setRotation(float pitch, float yaw) {
            this.pitch = pitch; this.yaw = yaw;
        }

        public void addKeyframe(CameraKeyframe kf) {
            keyframes.add(kf);
        }

        public List<CameraKeyframe> getKeyframes() {
            return keyframes;
        }

        /** Interpolate camera for a given frame */
        public void applyFrame(int frame) {
            if (keyframes.isEmpty()) return;
            CameraKeyframe prev = keyframes.get(0);
            CameraKeyframe next = keyframes.get(keyframes.size() - 1);

            for (int i = 0; i < keyframes.size(); i++) {
                if (keyframes.get(i).frame >= frame) {
                    next = keyframes.get(i);
                    if (i > 0) prev = keyframes.get(i - 1);
                    break;
                }
            }

            double t = (frame - prev.frame) / (double)(next.frame - prev.frame);
            t = Math.min(Math.max(t, 0), 1);

            // Linear interpolation
            this.x = lerp(prev.x, next.x, t);
            this.y = lerp(prev.y, next.y, t);
            this.z = lerp(prev.z, next.z, t);
            this.pitch = (float) lerp(prev.pitch, next.pitch, t);
            this.yaw = (float) lerp(prev.yaw, next.yaw, t);
        }

        private double lerp(double a, double b, double t) {
            return a + (b - a) * t;
        }
    }

    // ------------------- CameraKeyframe Class -------------------
    public static class CameraKeyframe {
        public final double x, y, z;
        public final float pitch, yaw;
        public final int frame;

        public CameraKeyframe(double x, double y, double z, float pitch, float yaw, int frame) {
            this.x = x; this.y = y; this.z = z;
            this.pitch = pitch; this.yaw = yaw;
            this.frame = frame;
        }
    }

    // ------------------- CameraPath Class -------------------
    public static class CameraPath {
        private final List<CameraKeyframe> keyframes = new ArrayList<>();

        public void addKeyframe(CameraKeyframe kf) {
            keyframes.add(kf);
        }

        public List<CameraKeyframe> getKeyframes() { return keyframes; }

        public CameraKeyframe getFrame(int frame) {
            if (keyframes.isEmpty()) return null;

            CameraKeyframe prev = keyframes.get(0);
            CameraKeyframe next = keyframes.get(keyframes.size() - 1);

            for (int i = 0; i < keyframes.size(); i++) {
                if (keyframes.get(i).frame >= frame) {
                    next = keyframes.get(i);
                    if (i > 0) prev = keyframes.get(i - 1);
                    break;
                }
            }

            double t = (frame - prev.frame) / (double)(next.frame - prev.frame);
            t = Math.min(Math.max(t, 0), 1);

            return new CameraKeyframe(
                    lerp(prev.x, next.x, t),
                    lerp(prev.y, next.y, t),
                    lerp(prev.z, next.z, t),
                    (float) lerp(prev.pitch, next.pitch, t),
                    (float) lerp(prev.yaw, next.yaw, t),
                    frame
            );
        }

        private double lerp(double a, double b, double t) {
            return a + (b - a) * t;
        }
    }

    // ------------------- CameraController Class -------------------
    public static class CameraController {
        private CineCamera camera;

        public CameraController(CineCamera camera) {
            this.camera = camera;
        }

        public void setCamera(CineCamera camera) { this.camera = camera; }

        public void update(int frame) {
            if (camera != null) camera.applyFrame(frame);
        }

        public CineCamera getCamera() { return camera; }
    }
}
