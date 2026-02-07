package com.yourname.cinecraft.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a character/actor in CineCraft
 */
public class ActorEntity {

    private String name;
    private double x, y, z;
    private double rotationYaw, rotationPitch;
    private Animator animator;

    public ActorEntity(String name){
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.rotationYaw = 0;
        this.rotationPitch = 0;
        this.animator = new Animator(this);
    }

    public void setPosition(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
    }

    public void setRotation(double yaw, double pitch){
        this.rotationYaw = yaw;
        this.rotationPitch = pitch;
    }

    public void update(int tick){
        animator.update(tick);
    }

    public Animator getAnimator(){ return animator; }

    // Getters
    public double getX(){ return x; }
    public double getY(){ return y; }
    public double getZ(){ return z; }
    public double getYaw(){ return rotationYaw; }
    public double getPitch(){ return rotationPitch; }
}
