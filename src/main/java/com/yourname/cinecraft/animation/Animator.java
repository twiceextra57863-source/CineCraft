package com.yourname.cinecraft.animation;

public class Animator {

    public void applyFrame(ActorEntity actor, AnimationClip clip, int frame) {
        if (clip.getKeyframes().isEmpty()) return;

        Keyframe prev = clip.getKeyframes().get(0);
        Keyframe next = clip.getKeyframes().get(clip.getKeyframes().size() - 1);

        for(int i=0;i<clip.getKeyframes().size();i++){
            if(clip.getKeyframes().get(i).frame >= frame){
                next = clip.getKeyframes().get(i);
                if(i>0) prev = clip.getKeyframes().get(i-1);
                break;
            }
        }

        double t = (frame - prev.frame)/(double)(next.frame - prev.frame);
        t = Math.min(Math.max(t,0),1);

        // TODO: Apply interpolated positions/rotations to actor bones
    }
}
