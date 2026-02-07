package com.yourname.cinecraft.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * AnimationClip stores keyframes for an actor animation
 */
public class AnimationClip {

    private String name;
    private int lengthTicks;
    private List<Keyframe> keyframes;

    public AnimationClip(String name, int lengthTicks){
        this.name = name;
        this.lengthTicks = lengthTicks;
        this.keyframes = new ArrayList<>();
    }

    public void addKeyframe(Keyframe kf){ keyframes.add(kf); }

    public Keyframe getKeyframe(int tick){
        if(keyframes.isEmpty()) return null;
        // Return last keyframe if tick exceeds
        if(tick >= lengthTicks) return keyframes.get(keyframes.size()-1);

        // Find surrounding keyframes
        Keyframe prev = keyframes.get(0);
        Keyframe next = keyframes.get(keyframes.size()-1);
        for(int i=0;i<keyframes.size()-1;i++){
            if(keyframes.get(i).tick <= tick && keyframes.get(i+1).tick >= tick){
                prev = keyframes.get(i);
                next = keyframes.get(i+1);
                break;
            }
        }
        // Interpolation can be added here
        return prev;
    }

    public int getLengthTicks(){ return lengthTicks; }
    public List<Keyframe> getKeyframes(){ return keyframes; }
}
