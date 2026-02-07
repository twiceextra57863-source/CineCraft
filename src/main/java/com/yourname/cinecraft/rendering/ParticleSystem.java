package com.yourname.cinecraft.rendering;

import java.util.ArrayList;
import java.util.List;

/**
 * Particle system for explosions, sparks, smoke
 */
public class ParticleSystem {

    public static class Particle{
        public double x, y, z;
        public double vx, vy, vz;
        public int lifetime;
        public String type;

        public Particle(double x, double y, double z, double vx, double vy, double vz, int lifetime, String type){
            this.x=x;this.y=y;this.z=z;this.vx=vx;this.vy=vy;this.vz=vz;this.lifetime=lifetime;this.type=type;
        }
    }

    private final List<Particle> particles = new ArrayList<>();

    public void spawnParticle(Particle p){ particles.add(p); }

    public void update(){
        for(int i=particles.size()-1;i>=0;i--){
            Particle p = particles.get(i);
            p.x+=p.vx; p.y+=p.vy; p.z+=p.vz;
            p.lifetime--;
            if(p.lifetime<=0) particles.remove(i);
        }
    }

    public void render(){
        for(Particle p: particles){
            // TODO: Draw particle based on type, position
        }
    }
}
