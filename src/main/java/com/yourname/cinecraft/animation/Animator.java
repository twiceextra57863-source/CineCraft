package com.yourname.cinecraft.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Animator applies AnimationClips to ActorEntity
 */
public class Animator {

    private ActorEntity actor;
    private List<AnimationClip> clips;
    private int currentTick;

    public Animator(ActorEntity actor){
        this.actor = actor;
        this.clips = new ArrayList<>();
        this.currentTick = 0;
    }

    public void addClip(AnimationClip clip){ clips.add(clip); }

    public void update(int tick){
        this.currentTick = tick;
        for(AnimationClip clip : clips){
            if(tick <= clip.getLengthTicks()){
                Keyframe kf = clip.getKeyframe(tick);
                if(kf != null){
                    actor.setPosition(kf.x, kf.y, kf.z);
                    actor.setRotation(kf.yaw, kf.pitch);
                    // apply rig bones
                    Rig rig = kf.rig;
                    for(String boneName : rig.getBones().keySet()){
                        actor.getAnimator().getRig().getBone(boneName).setPosition(
                            rig.getBone(boneName).getX(),
                            rig.getBone(boneName).getY(),
                            rig.getBone(boneName).getZ()
                        );
                        actor.getAnimator().getRig().getBone(boneName).setRotation(
                            rig.getBone(boneName).getRotX(),
                            rig.getBone(boneName).getRotY(),
                            rig.getBone(boneName).getRotZ()
                        );
                    }
                }
                break;
            }
        }
    }

    public Rig getRig(){ return actor.getAnimator().getRig(); }
}
