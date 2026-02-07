package com.yourname.cinecraft.camera;

import com.yourname.cinecraft.CineCraftMod;

/**
 * CameraController allows real-time camera movement & rotation
 * Supports:
 * - WASD / arrow movement
 * - Mouse rotation
 * - Zoom in/out (FOV)
 * - Integration with CineCamera
 */
public class CameraController {

    private CineCamera camera;

    // Movement speed
    private double moveSpeed = 0.2;
    private double rotSpeed = 2.0; // degrees per input tick
    private double zoomSpeed = 2.0;

    public CameraController(CineCamera camera){
        this.camera = camera;
    }

    /**
     * Update camera position based on input
     * @param forward - positive for forward, negative backward
     * @param strafe - positive for right, negative left
     * @param updown - positive up, negative down
     * @param yawDelta - mouse yaw change
     * @param pitchDelta - mouse pitch change
     * @param zoomDelta - FOV change
     */
    public void update(double forward, double strafe, double updown, double yawDelta, double pitchDelta, double zoomDelta){
        double radYaw = Math.toRadians(camera.getYaw());
        double sinYaw = Math.sin(radYaw);
        double cosYaw = Math.cos(radYaw);

        // Move forward/backward
        camera.setX(camera.getX() + (forward * cosYaw - strafe * sinYaw) * moveSpeed);
        camera.setZ(camera.getZ() + (forward * sinYaw + strafe * cosYaw) * moveSpeed);
        camera.setY(camera.getY() + updown * moveSpeed);

        // Rotate
        camera.setYaw(camera.getYaw() + yawDelta * rotSpeed);
        camera.setPitch(camera.getPitch() + pitchDelta * rotSpeed);

        // Clamp pitch
        if(camera.getPitch() > 90) camera.setPitch(90);
        if(camera.getPitch() < -90) camera.setPitch(-90);

        // Zoom
        camera.setFov(camera.getFov() + zoomDelta * zoomSpeed);
        if(camera.getFov() < 10) camera.setFov(10);
        if(camera.getFov() > 120) camera.setFov(120);
    }

    // Optional: setters for speed
    public void setMoveSpeed(double speed){ this.moveSpeed = speed; }
    public void setRotSpeed(double speed){ this.rotSpeed = speed; }
    public void setZoomSpeed(double speed){ this.zoomSpeed = speed; }
}
