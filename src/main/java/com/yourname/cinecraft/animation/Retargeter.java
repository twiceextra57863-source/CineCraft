package com.yourname.cinecraft.animation;

/**
 * Retargeter maps keyframes from one rig to another
 */
public class Retargeter {

    public static Rig retarget(Rig source, Rig target){
        Rig newRig = target.clone();
        for(String boneName : source.getBones().keySet()){
            if(newRig.getBones().containsKey(boneName)){
                Bone src = source.getBone(boneName);
                Bone tgt = newRig.getBone(boneName);
                tgt.setPosition(src.getX(), src.getY(), src.getZ());
                tgt.setRotation(src.getRotX(), src.getRotY(), src.getRotZ());
            }
        }
        return newRig;
    }
}
