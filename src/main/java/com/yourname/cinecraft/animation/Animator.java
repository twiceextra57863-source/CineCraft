package com.yourname.cinecraft.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles animation keyframes for ActorEntity
 */
public class Animator {

    private ActorEntity actor;
    private List<Keyframe> keyframes;
    private int currentTick;

    public Animator(ActorEntity actor){
        this.actor = actor;
        this.keyframes = new ArrayList<>();
        this.currentTick = 0;
    }

    public void addKeyframe(Keyframe kf){ keyframes.add(kf); }

    public void update(int tick){
        currentTick = tick;
        if(keyframes.isEmpty()) return;

        // Find two keyframes to interpolate between
        Keyframe prev = keyframes.get(0);
        Keyframe next = keyframes.get(keyframes.size()-1);

        for(int i=0;i<keyframes.size()-1;i++){
            if(keyframes.get(i).tick <= tick && keyframes.get(i+1).tick >= tick){
                prev = keyframes.get(i);
                next = keyframes.get(i+1);
                break;
            }
        }

        double alpha = (double)(tick - prev.tick)/(next.tick - prev.tick);
        double interpX = prev.x + (next.x - prev.x) * alpha;
        double interpY = prev.y + (next.y - prev.y) * alpha;
        double interpZ = prev.z + (next.z - prev.z) * alpha;

        actor.setPosition(interpX, interpY, interpZ);
        actor.setRotation(prev.yaw + (next.yaw - prev.yaw)*alpha,
                          prev.pitch + (next.pitch - prev.pitch)*alpha);
    }
}
